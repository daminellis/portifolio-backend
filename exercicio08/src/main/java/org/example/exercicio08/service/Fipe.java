package org.example.exercicio08.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;

@Service
public class fipe {
    private final RestClient restClient = RestClient.create("https://parallelum.com.br");

    public String getBrandCode(String brandName) {
        List<HashMap<String, Object>> response = restClient
                .get()
                .uri("/fipe/api/v1/carros/marcas")
                .retrieve()
                .body(List.class);

        if (response != null) {
            for (HashMap<String, Object> marca : response) {
                if (marca.get("nome").toString().equalsIgnoreCase(brandName)) {
                    return marca.get("codigo").toString();
                }
            }
        }
        return null;
    }

    public String getModelCode(String brandCode, String modelName) {
        HashMap<String, Object> response = restClient
                .get()
                .uri("/fipe/api/v1/carros/marcas/" + brandCode + "/modelos")
                .retrieve()
                .body(HashMap.class);

        if (response != null && response.containsKey("modelos")) {
            List<HashMap<String, Object>> models = (List<HashMap<String, Object>>) response.get("modelos");
            for (HashMap<String, Object> model : models) {
                if (model.get("nome").toString().equalsIgnoreCase(modelName)) {
                    return model.get("codigo").toString();
                }
            }
        }
        return null;
    }

    public String getYearCode(String brandCode, String modelCode, String yearName) {
        List<HashMap<String, Object>> response = restClient
                .get()
                .uri("/fipe/api/v1/carros/marcas/" + brandCode + "/modelos/" + modelCode + "/anos")
                .retrieve()
                .body(List.class);

        if (response != null) {
            for (HashMap<String, Object> ano : response) {
                if (ano.get("nome").toString().equalsIgnoreCase(yearName)) {
                    return ano.get("codigo").toString();
                }
            }
        }
        return null;
    }

    public HashMap<String, String> getValue(String brandCode, String modelCode, String yearCode) {
        HashMap<String, String> requestResponse = new HashMap<>();

        HashMap<String, Object> resposta = restClient
                .get()
                .uri("/fipe/api/v1/carros/marcas/" + brandCode + "/modelos/" + modelCode + "/anos/" + yearCode)
                .retrieve()
                .body(HashMap.class);

        if (resposta != null) {
            requestResponse.put("valor", resposta.get("Valor").toString());
            requestResponse.put("mes", resposta.get("MesReferencia").toString());
        }
        return requestResponse;
    }
}