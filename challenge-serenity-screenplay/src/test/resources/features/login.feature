Feature: Ingresar a la pantalla login
@authenticationLogin
   Scenario Outline: Login exitoso con credenciales válidas
    Given que el usuario abre la página de inicio de sesión
    When ingresa el usuario <string>
    And ingresa la contraseña <string1>
    And hace clic en el botón de inicio de sesión
    Then el usuario debería ver la página de productos
    And debería ver el título <string2>
    Examples:
      | actor     | string          | string1        | string2     |
      | "cliente" | "standard_user" | "secret_sauce" | "Swag Labs" |

  @validar
  Scenario Outline: Login exitoso con credenciales válidas
    Given que el usuario <actor> abre la página de inicio de sesión
    When selecciona maximo 2 productos al carrito
    And hace clic en el botón "Add to cart"
    Then se debe visualizar el carrito con 2 items
    Examples:
      | actor     |
      | "cliente" |

