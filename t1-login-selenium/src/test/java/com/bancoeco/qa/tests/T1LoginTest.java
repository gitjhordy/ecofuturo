package com.bancoeco.qa.tests;

import com.bancoeco.qa.base.BaseTest;
import com.bancoeco.qa.pages.DashboardPage;
import com.bancoeco.qa.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Tarea T1 - Login OrangeHRM")
class T1LoginTest extends BaseTest {

    @Test
    @DisplayName("Login válido permite ingresar al Dashboard")
    void loginValidoLlegaAlDashboard() {
        LoginPage loginPage = new LoginPage(driver, wait).esperarCarga();
        loginPage.iniciarSesion("Admin", "admin123");

        DashboardPage dashboardPage = new DashboardPage(driver, wait).esperarCarga();

        assertAll("El usuario autenticado debe quedar en el Dashboard",
                () -> assertEquals("Dashboard", dashboardPage.obtenerTitulo(),
                        "El encabezado principal debe identificar el Dashboard"),
                () -> assertTrue(dashboardPage.obtenerUrlActual().contains("/dashboard/index"),
                        "La URL debe corresponder al Dashboard"),
                () -> assertTrue(dashboardPage.menuUsuarioEstaVisible(),
                        "El menú del usuario autenticado debe estar visible"));
    }

    @Test
    @DisplayName("Contraseña incorrecta muestra error y mantiene el login")
    void loginConContrasenaIncorrectaMuestraError() {
        LoginPage loginPage = new LoginPage(driver, wait).esperarCarga();
        loginPage.iniciarSesion("Admin", "contrasena_incorrecta");

        assertAll("El acceso inválido debe ser rechazado de forma controlada",
                () -> assertEquals("Invalid credentials", loginPage.obtenerMensajeError(),
                        "Debe mostrarse el mensaje de credenciales inválidas"),
                () -> assertTrue(loginPage.obtenerUrlActual().contains("/auth/login"),
                        "El usuario debe permanecer en la página de login"),
                () -> assertTrue(loginPage.formularioEstaVisible(),
                        "El formulario debe permanecer disponible para reintentar"));
    }
}
