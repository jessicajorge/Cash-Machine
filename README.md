# Cash-Machine
API Rest de simulação de um caixa eletrônico utilizando Java 8, Spring Boot e Gradle
Um caixa eletrônico opera com notas de R$ 50,00, R$ 20,00, R$ 10,00, R$ 5,00 e R$2,00, mantendo um estoque de cédulas para cada valor. 
Os clientes do banco podem efetuar saques com valor maior que 0 e menor que 10000.
A quantidade de cédulas entregues para totalizar esse valor é feito de modo que a quantidade de notas entregues seja mínima.
Exemplo 1: Se o cliente deseja retirar R$ 50,00, basta entregar uma única nota de cinquenta reais. 
Exemplo 2: Se o cliente deseja retirar R$ 92,00, é necessário entregar uma nota de R$50,00, duas de R$ 20,00 e uma de R$2,00.
