# Tarea T1 - Login OrangeHRM con Selenium

Este proyecto automatiza el login de `https://opensource-demo.orangehrmlive.com/web/index.php/auth/login` con Java, Selenium WebDriver y JUnit 5.

## Casos automatizados

1. Login válido con `Admin / admin123`: verifica la URL del Dashboard y el título `Dashboard`.
2. Login con contraseña incorrecta: verifica el mensaje `Invalid credentials`.

Las dos pruebas usan esperas explícitas de Selenium y cada prueba cierra Chrome mediante `driver.quit()` en `@AfterEach`.

## Estructura

- `base/BaseTest.java`: creación y cierre del navegador.
- `config/TestConfig.java`: URL, timeout y modo visual configurables.
- `pages/LoginPage.java`: localizadores y acciones del formulario de acceso.
- `pages/DashboardPage.java`: validaciones de la pantalla posterior al login.
- `tests/T1LoginTest.java`: escenarios y aserciones de negocio.
- `support/ScreenshotOnFailureExtension.java`: captura automática en `target/evidencias` cuando falla una prueba.

## Relación con la rúbrica

| Criterio | Implementación |
| --- | --- |
| Compilación y ejecución | Maven, Java 17 y JUnit 5; validación con `mvn test`. |
| Localizadores | `By.name` y selectores CSS estables, centralizados en Page Objects. |
| Esperas explícitas | `WebDriverWait` y `ExpectedConditions`; no se utiliza `Thread.sleep`. |
| Aserciones | Se validan encabezado, URL, menú de usuario, mensaje de error y permanencia en login. |
| Caso negativo | Contraseña incorrecta con validación del estado final. |
| Estructura | Base Test, configuración, Page Objects, soporte y pruebas separados. |
| Limpieza | `driver.quit()` en `@AfterEach`, incluso si una aserción falla. |
| Depuración | Mensajes descriptivos, parámetros configurables y captura automática ante fallos. |

Parámetros opcionales:

```powershell
mvn "-Dvisual=true" "-Dtimeout=30" test
```

## Ejecutar desde consola

```powershell
Set-Location "D:\per\banco eco\t1-login-selenium"
mvn test
```

Para observar Chrome:

```powershell
mvn "-Dvisual=true" test
```

También se puede ejecutar `ejecutar-t1.cmd` o `ejecutar-t1-visual.cmd` con doble clic.

## Ejecutar desde IntelliJ IDEA

1. Abrir esta carpeta como proyecto.
2. Esperar la importación de Maven.
3. Abrir `T1LoginTest.java`.
4. Presionar el triángulo verde junto a la clase para ejecutar las dos pruebas.
5. Para ejecución visual, agregar `-Dvisual=true` en **Run > Edit Configurations > VM options**.
