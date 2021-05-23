# validator

## A solução
Foi criado um validador de senha com as regras solicitadas utilizando o padrão de projeto Chain of Responsability onde uma classe abstrata foi criada e cada uma das regras foi codificada em diferentes classes extendidas. Esse padrão foi escolhido por deixar o código mais legível e de fácil manutenção no caso de mais regras serem adicionadas, alteradas ou excluídas.

## Outras regras implementadas
Pelos exemplo que foram dados não ficaram claras duas regras:
- IsValid("aa") // false  - o sistema deve considerar como caracter repetido letras iguais em caixa baixa e em caixa alta como por exemplo "Aa"? Eu deduzi que não, pois essas letras possuem encoding diferentes. 
- IsValid("ab") // false  - o sistema deve validar se existem sequências de letras e de números? As regras não especificavam isso, porém pelo exemplo dado e pelas regras de segurança de senha em geral deduzi que deveria validar. Aqui não considerei como sequência a mesma letra em caixa baixa e caixa alta por exemplo, "Ab" não seria considerado inválido.

## Instalação
- Pré-requisitos
  - Java 8 ou acima
  - Maven ou use o wrapper ./mvnw
  - Spring boot 2.4.0

- Baixe o projeto

```
git clone https://github.com/fearrazi/validator.git
```

Para rodar os testes utilize o script abaixo

```
./mvnw test
```

Para subir o projeto utilize o script abaixo

```
./mvnw spring-boot:run
```

Para executar chamada no endpoint utilizar o curl da seguinte forma

```
curl --location --request POST 'http://localhost:8080/validator' \
--header 'Content-Type: application/json' \
--data-raw '{
    "password":"AbTp9!fok"
}'
```
