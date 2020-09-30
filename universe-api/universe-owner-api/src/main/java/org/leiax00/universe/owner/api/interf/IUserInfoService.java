package org.leiax00.universe.owner.api.interf;

public interface IUserInfoService<T> {
    T findByUsername(String username);

    String generateToken(T t);

    boolean isValidToken(String token);

    T validateAndReturnUser(String token);

    void removeToken(String token);
}
