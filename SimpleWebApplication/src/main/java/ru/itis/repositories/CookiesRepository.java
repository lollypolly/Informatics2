package ru.itis.repositories;

import javax.servlet.http.Cookie;

public interface CookiesRepository extends CrudRepository<Cookie>{
    void save(Cookie entity, int user_id);
}
