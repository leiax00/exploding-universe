package interf;

public interface IUserInfoService<T> {
    T findByUsername(String username);

    String generateToken(T t);

    boolean isValidToken(String token);
}
