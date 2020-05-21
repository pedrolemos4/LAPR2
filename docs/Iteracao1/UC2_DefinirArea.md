# UC2 - Definir Área de Atividade

## 1. Engenharia de Requisitos

### Formato Breve

O administrativo inicia a definição de uma nova área de atividade. O sistema solicita os dados necessários (i.e. código único e descrição breve e detalhada). O administrativo introduz os dados solicitados. O sistema valida e apresenta os dados ao administrativo, pedindo que os confirme. O administrativo confirma. O sistema regista os dados e informa o administrativo do sucesso da operação.

### SSD
![UC2_SSD.svg](UC2_SSD.svg)


### Formato Completo

#### Ator principal

Administrativo

#### Partes interessadas e seus interesses
* **Administrativo:** pretende definir as áreas de atividade para que possa posteriormente catalogar as competências técnicas e categorias de tarefas.
* **T4J:** pretende que a plataforma permita catalogar as competências técnicas e as categorias de tarefas em áreas de atividade.


#### Pré-condições
n/a

#### Pós-condições
A informação da área de atividade é registada no sistema.

### Cenário de sucesso principal (ou fluxo básico)

1. O administrativo inicia a definição de uma nova área de atividade. 
2. O sistema solicita os dados necessários (i.e. código único, descrição breve e detalhada). 
3. O administrativo introduz os dados solicitados. 
4. O sistema valida e apresenta os dados ao administrativo, pedindo que os confirme. 
5. O administrativo confirma. 
6. O sistema regista os dados e informa o administrativo do sucesso da operação.


#### Extensões (ou fluxos alternativos)

*a. O administrativo solicita o cancelamento da definição da  área de atividade.

> O caso de uso termina.

4a. Dados mínimos obrigatórios em falta.
>	1. O sistema informa quais os dados em falta.
>	2. O sistema permite a introdução dos dados em falta (passo 3)
>
	>	2a. O administrativo não altera os dados. O caso de uso termina.

4b. O sistema deteta que os dados (ou algum subconjunto dos dados) introduzidos devem ser únicos e que já existem no sistema.
>	1. O sistema alerta o administrativo para o facto.
>	2. O sistema permite a sua alteração (passo 3)
>
	>	2a. O administrativo não altera os dados. O caso de uso termina.

4c. O sistema detecta que os dados introduzidos (ou algum subconjunto dos dados) são inválidos.
> 1. O sistema alerta o administrativo para o facto. 
> 2. O sistema permite a sua alteração (passo 3).
> 
	> 2a. O administrativo não altera os dados. O caso de uso termina. 

#### Requisitos especiais
\-

#### Lista de Variações de Tecnologias e Dados
\-

#### Frequência de Ocorrência
\-

#### Questões em aberto

* Existem outros dados que são necessários?
* Todos os dados são obrigatórios?
* O código único é sempre introduzido pelo administrativo ou o sistema deve gerá-lo automaticamente?
* Qual a frequência de ocorrência deste caso de uso?


## 2. Análise OO

### Excerto do Modelo de Domínio Relevante para o UC

![UC2_MD.svg](UC2_MD.svg)


## 3. Design - Realização do Caso de Uso

### Racional

| Fluxo Principal | Questão: Que Classe... | Resposta  | Justificação  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
| 1. O administrativo inicia a definição de uma nova área de atividade.   		 |	... interage com o utilizador? | DefinirAreaUI    |  Pure Fabrication, pois não se justifica atribuir esta responsabilidade a nenhuma classe existe no Modelo de Domínio. |
|  		 |	... coordena o UC?	| DefinirAreaController | Controller    |
|  		 |	... cria instância de AreaAtividade| Plataforma   | Creator (Regra1)   |
| 2. O sistema solicita os dados necessários (i.e. código único, descrição breve e detalhada).  		 |							 |             |                              |
| 3. O administrativo introduz os dados solicitados.  		 |	... guarda os dados introduzidos?  |   AreaAtividade | Information Expert (IE) - instância criada no passo 1     |
| 4. O sistema valida e apresenta os dados ao administrativo, pedindo que os confirme.   		 |	...valida os dados da Area (validação local) | AreaAtividade |                              |IE. Possui os seu próprios dados.|  	
|	 |	...valida os dados da Area (validação global) | Plataforma  | IE: A Plataforma possui/agrega AreaAtividade  |
| 5. O administrativo confirma.   		 |							 |             |                              |
| 6. O sistema regista os dados e informa o administrativo do sucesso da operação.  		 |	... guarda a AreaAtividade criada? | Plataforma  | IE: No MD a Plataforma possui AreaAtividade|  
             

### Sistematização ##

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * Plataforma
 * AreaAtividade


Outras classes de software (i.e. Pure Fabrication) identificadas:  

 * DefinirAreaUI  
 * DefinirAreaController


###	Diagrama de Sequência

![UC2_SD.svg](UC2_SD.svg)


###	Diagrama de Classes

![UC2_CD.svg](UC2_CD.svg)




