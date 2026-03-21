# SPA-PROYECT

> *más bonito*

## Backend

Este backend está hecho con:

> *odié mysql*
- Mysql Database (Solo para test)
- Oracle Database verión 23.x (Solo para devs y Docker)
- Lombok
- JPA
> *Para ver bien los endpoints y no mandarme una embarrada.*
- OpenApi

> * **Consideraciones**: application.properties posee el profile por defecto en test.*
## Frontend

- Hecho con react.
- Node 24.x

## Como usar:

### Test

- Para este módulo, se requiere XAMPP:
    - **Recomendado**: En el backend, 'application.properties' cambia el profile a test
    - Abre XAMPP e inicia Apache y Mysql.
    - Luego de iniciar los atributos de XAMPP, Crea una nueva Database llamada spa_proyect22 (Entra a la opción admin de XAMPP en la altura de Mysql).
    - inicia 'BackendApplication.java' que esta dentro de las carpetas de backend.
    - **Recomendación**: Usa postman para crear los objetos para probar la página.
    - **Recomendación**: Guiate con el Swagger -> [http://localhost:8080/doc/swagger-ui.html](http://localhost:8080/doc/swagger-ui.html)
    - muevete al Frontend (´cd frontend´) en la terminal e inicia el comando ´npm run dev´.
    Luego de iniciar, te mandará un link. usalo.

### DEV

**IMPORTANTE**
*Se requiere la Oracle wallet, cosa que no será publicada en github o docker.*

- Para este módulo se requiere Docker Desktop:
    - Inicia Docker Desktop
    - **Recomendado**: En el backend, 'application.properties' cambia el profile a dev
    - inicia el comando en Gitbash ´docker-compose up --build´
    - Espera un poco, ya que docker-compose.yml posee las configuraciones necesarias.
    - **Recomendación**: Usa postman para crear los objetos para probar la página. (El backend actualmente posee 2 ejemplos.)
    - **Recomendación**: Guiate con el Swagger -> [http://localhost:8080/doc/swagger-ui.html](http://localhost:8080/doc/swagger-ui.html)
    - Despues de activar la aplicación en docker, se podrá entrar al frontend a través del port: 3000:80

