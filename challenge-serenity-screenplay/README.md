# Test E2E Automation — Serenity BDD + Screenplay

Prueba funcional automatizada (E2E) del flujo de compra en [https://www.saucedemo.com](https://www.saucedemo.com) utilizando Serenity BDD con el patrón Screenplay, Cucumber y JUnit 5.

---

## Tecnologías y versiones requeridas

| Tecnología | Versión | Propósito |
|---|---|---|
| Java (JDK) | 17 | Lenguaje base del proyecto |
| Gradle | 8.x (Wrapper incluido) | Herramienta de build |
| Serenity BDD | 5.3.7 | Framework de pruebas con reportes |
| Serenity Screenplay | 5.3.7 | Patrón de diseño para los actores |
| Serenity Screenplay WebDriver | 5.3.7 | Interacciones web vía Screenplay |
| Serenity Cucumber | 5.3.7 | Integración Cucumber + Serenity |
| Serenity JUnit 5 | 5.3.7 | Integración JUnit 5 + Serenity |
| Cucumber Java | 7.14.0 | BDD con Gherkin |
| Cucumber JUnit Platform Engine | 7.14.0 | Motor de ejecución de Cucumber |
| JUnit Platform Suite | 6.0.3 | Runner de pruebas |
| AssertJ | 3.27.3 | Librería de aserciones |
| Logback Classic | 1.5.18 | Logging |
| Google Chrome | 146.x | Navegador de ejecución |
| ChromeDriver | 146.x (auto-descarga) | Driver para Selenium/Serenity |

---

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

1. **JDK 17** — verificar con:
   ```bash
   java -version
   ```
   Debe mostrar: `openjdk version "17.x.x"`

2. **Google Chrome** — versión 146 o superior.
   ChromeDriver se descarga automáticamente gracias a `webdriver.autodownload = true` en `serenity.conf`.

3. **Conexión a internet** — necesaria para descargar dependencias de Maven Central y acceder a `https://www.saucedemo.com`.

---

## Instalación y configuración

### 1. Clonar o descomprimir el proyecto

```bash
# Si tienes el repositorio en Git
git clone <url-del-repositorio>
cd demo-serenity-screenplay-gradle
```

### 2. Verificar el Gradle Wrapper

El proyecto incluye `gradlew` (Linux/Mac) y `gradlew.bat` (Windows). No es necesario instalar Gradle globalmente.

```bash
# Linux / Mac
./gradlew --version

# Windows
gradlew.bat --version
```

### 3. Verificar el `serenity.conf`

Confirma que el archivo `src/test/resources/serenity.conf` contiene:

```hocon
webdriver {
  driver = chrome
  autodownload = true
  capabilities {
    browserName = "chrome"
    "goog:chromeOptions" {
         args = ["start-maximized","test-type", "ignore-certificate-errors",
           "incognito", "disable-infobars", "disable-gpu", "disable-default-apps", "disable-popup-blocking", "remote-allow-origins=*"]
    }
  }
}
chrome.switches = "--start-maximized;--disable-notifications;--remote-allow-origins=*"
serenity {
  project.name = "SauceDemo E2E Purchase Flow"
  take.screenshots = FOR_EACH_ACTION
  restart.browser.for.each = never
}

environments {
  default {
    webdriver.base.url = "https://www.saucedemo.com"
  }
}

timeouts {
  implicit.wait = 10
  fluent.wait = 10
}
```


---

## Ejecución de las pruebas

### Ejecutar todos los tests y generar reporte

```bash
# Linux / Mac
./gradlew clean test aggregate

# Windows
gradlew.bat clean test aggregate
```

### Ejecutar solo el flujo de compra (tag `@purchase`)

```bash
./gradlew clean test -Dcucumber.filter.tags="@purchase" aggregate
```

### Ejecutar solo las validaciones del formulario (tag `@checkout_validation`)

```bash
./gradlew clean test -Dcucumber.filter.tags="@checkout_validation" aggregate
```

### Ejecutar con navegador en modo headless (sin ventana)


---

## Reporte de resultados

Después de ejecutar `aggregate`, el reporte HTML se genera en:

```
target/site/serenity/index.html
```

Ábrelo directamente en tu navegador:

```bash
# Linux / Mac
open target/site/serenity/index.html

# Windows
start target/site/serenity/index.html
```

---

## Estructura del proyecto

```
demo-serenity-screenplay-gradle/
│
├── build.gradle                          # Configuración de Gradle y dependencias
├── gradlew                               # Gradle Wrapper (Linux/Mac)
├── gradlew.bat                           # Gradle Wrapper (Windows)
├── settings.gradle                       # Nombre del proyecto
│
└── src/
    └── main/
        ├── java/
       │     └── org/challenge/
       │        ├── tasks/
       │        │   ├── Login.java                     # Task: autenticación
       │        │   ├── AddProductToCart.java          # Task: agregar productos
       │        │   ├── Checkout.java                  # Task: navegar al carrito
       │        │   ├── CompletePurchase.java          # Task: completar compra
       │        │   ├── FillCheckoutForm.java          # Task: llenar formulario
       │        │   ├── SubmitCheckoutForm.java        # Task: enviar formulario
       │        │   └── NavigateToCheckoutForm.java    # Task: ir al checkout
       │        │
       │        ├── questions/
       │        │   ├── TheConfirmationMessage.java    # Question: mensaje de confirmación
       │        │   ├── TheCartItemCount.java          # Question: items en el carrito
       │        │   ├── TheFieldValue.java             # Question: valor de un campo
       │        │   ├── TheCheckoutFormError.java      # Question: error en el formulario
       │        │   └── TheCurrentPageUrl.java         # Question: URL actual
       │        │
       │        ├── ui/
       │        │   ├── LoginPage.java                 # Locators de login
       │        │   ├── InventoryPage.java             # Locators de inventario
       │        │   ├── CartPage.java                  # Locators del carrito
       │        │   ├── CheckoutPage.java              # Locators del formulario
       │        │   └── ConfirmationPage.java          # Locators de confirmación
       │        │
       │        └── utils/
       │            └── Constants.java                 # URLs y credenciales
       │     
       │    
    └── test/
        ├── java/
        │   └── org/challenge/
        │       │
        │       ├── runners/
        │       │   └── LoginRunner.java        # Suite JUnit 5 + Serenity
        │       │
        │       ├── stepdefinitions/
        │       │   ├── PurchaseStep.java   # Steps del flujo de compra
        │       │   └── LoginStep.java # Steps de validación de login
        │       │
        │       
        │
        └── resources/
            ├── serenity.conf                          # Configuración de Serenity
            └── features/
                ├── purchase_flow.feature              # Escenario E2E de compra
                └── checkout_validation.feature        # Escenarios de validación del formulario
```

---

## Descripción de los escenarios

### `purchase_flow.feature` — Flujo de compra E2E

| Paso | Acción |
|---|---|
| 1 | Autenticarse con `standard_user` / `secret_sauce` |
| 2 | Agregar 2 productos al carrito |
| 3 | Navegar al carrito y verificar 2 ítems |
| 4 | Completar formulario: `Test` / `User` / `12345` |
| 5 | Verificar mensaje `THANK YOU FOR YOUR ORDER` |

### `checkout_validation.feature` — Validación sin límite de caracteres

10 escenarios que validan que los campos del formulario de checkout aceptan:

- Valores cortos (1-2 caracteres)
- Valores estándar
- Nombres largos con guiones
- Caracteres especiales (`@#$%`, `&*()`)
- Valores numéricos en campos de texto
- Espacios en los nombres
- Cadenas de hasta 100 caracteres

---



