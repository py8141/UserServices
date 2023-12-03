package com.example.CartOrderService.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)

@Builder

public class ApiResponse<T> {

     private String errorCode;
     private T resultData;
     private String errorDesc;
     private boolean result;


     public ApiResponse(T resultData){

         this.resultData = resultData;
         this.result = true;
     }


     public  ApiResponse(String errorDesc,String errorCode){

         this.errorDesc = errorDesc;
         this.errorCode= errorCode;
     }


}
