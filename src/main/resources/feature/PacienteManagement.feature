Feature: Gerenciamento de Pacientes

  # Cenário 1: Caminho feliz para criação de paciente com dados válidos
  Scenario: Criar paciente com dados válidos
    Given que o usuário tem permissão para criar pacientes
    When ele envia uma requisição POST para "/pacientes" com dados válidos do paciente
    Then o sistema deve responder com status 200
    And o corpo da resposta deve conter os detalhes do paciente criado

  # Cenário 2: Caminho de erro para criação de paciente com dados inválidos
  Scenario: Falha ao criar paciente com dados inválidos
    Given que o usuário tem permissão para criar pacientes
    When ele envia uma requisição POST para "/pacientes" com dados incompletos ou incorretos
    Then o sistema deve responder com status 400
    And o corpo da resposta deve conter uma mensagem de erro

  # Cenário 3: Caminho feliz para atualização de paciente existente com dados válidos
  Scenario: Atualizar paciente existente com dados válidos
    Given que existe um paciente cadastrado com ID 1
    When o usuário envia uma requisição PUT para "/pacientes/1" com dados válidos do paciente
    Then o sistema deve responder com status 200
    And o corpo da resposta deve conter os detalhes atualizados do paciente

  # Cenário 4: Caminho de erro para atualização de paciente com ID inexistente
  Scenario: Falha ao atualizar paciente com ID inexistente
    Given que não existe paciente cadastrado com o ID fornecido
    When o usuário envia uma requisição PUT para "/pacientes/{id_inexistente}"
    Then o sistema deve responder com status 404
    And o corpo da resposta deve conter uma mensagem de erro informando a inexistência do paciente

  # Cenário 5: Caminho feliz para exclusão de paciente existente
  Scenario: Excluir paciente existente
    Given que existe um paciente cadastrado com ID 1
    When o usuário envia uma requisição DELETE para "/pacientes/1"
    Then o sistema deve responder com status 204
    And o paciente não deve mais existir no sistema

  # Cenário 6: Recuperação de paciente inexistente
    Given que não existe paciente cadastrado com o ID 999
    When o usuário envia uma requisição GET para "/pacientes/999"
    Then o sistema deve responder com status 404
    And o corpo da resposta não deve conter dados de paciente

