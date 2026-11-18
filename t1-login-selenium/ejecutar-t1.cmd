@echo off
setlocal
cd /d "%~dp0"
set "JAVA_HOME=C:\Program Files\Java\jdk-17"
set "MAVEN_OPTS=-Djavax.net.ssl.trustStoreType=Windows-ROOT"
set "MAVEN_CMD=C:\Program Files\JetBrains\IntelliJ IDEA 2026.3\plugins\maven-plugin\lib\maven3\bin\mvn.cmd"

echo Ejecutando Tarea T1 - Login...
echo.
call "%MAVEN_CMD%" -B test
set "RESULTADO=%ERRORLEVEL%"
echo.
if "%RESULTADO%"=="0" (
    echo LAS DOS PRUEBAS DE LOGIN PASARON CORRECTAMENTE.
) else (
    echo LA EJECUCION FINALIZO CON ERRORES. Codigo: %RESULTADO%
)
echo.
if not defined NO_PAUSE pause
exit /b %RESULTADO%
