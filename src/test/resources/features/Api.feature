Feature: Order API
  @Apis
  Scenario Outline: Create an Order
    Given tengo una nueva orden  <id>,<petId>, <quantity>, <shipDate>, <status>, <complete>
    When envio una solicitud POST /store/order
    Then la respuesta deberia ser 200
    And  la orden ha sido creada
    Examples:
      | id | petId | quantity | shipDate                 | status   | complete |
      | 0  | 0     | 0        | 2024-08-07T22:56:53.036Z | placed   | True    |
      | 1  | 2     | 1        | 2024-08-08T12:34:56      | approved | False    |

  Scenario:Orden GET por ID
    Given tengo una orden ID 0
    When envio una solicitud GET /store/order/0
    Then la respuesta del codigo deberia ser 200
    And el detalle del orden deberia estar correcto