package validators;

import enums.Currency;
import io.qameta.allure.Step;
import static io.restassured.RestAssured.given;

public class RateSteps {
    public static final String BASE_URL = "https://kurs.onliner.by";
    public static final String RATE_ENDPOINT = "/sdapi/kurs/api/bestrate";

    @Step("Получить курс валюты")
    public String getResponse(Currency currency) {
        return given()
                .baseUri(BASE_URL)
                .log().all()
                .queryParam("currency", currency.getCode())
                .queryParam("type", "nbrb")
                .when()
                .get(RATE_ENDPOINT)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .asString();
    }
}
