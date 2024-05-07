package br.com.allanflm.screenmatch.service;

public interface IConvertsData {
    <T> T getData(String json, Class<T> classe);
}
