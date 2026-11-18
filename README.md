# Ecofuturo - Automatización QA

Repositorio de ejercicios de automatización web con Java, Selenium WebDriver, JUnit 5 y Maven.

## Tarea T1 - Login OrangeHRM

El proyecto `t1-login-selenium` contiene dos pruebas automatizadas:

1. Login válido con acceso al Dashboard.
2. Login con contraseña incorrecta y validación del mensaje de error.

Las pruebas utilizan Page Object Model, esperas explícitas, aserciones significativas, cierre automático del navegador y captura de pantalla ante fallos.

### Ejecutar

```powershell
Set-Location t1-login-selenium
mvn test
```

Modo visual:

```powershell
mvn "-Dvisual=true" test
```

Consulta `t1-login-selenium/README.md` para la documentación completa.
