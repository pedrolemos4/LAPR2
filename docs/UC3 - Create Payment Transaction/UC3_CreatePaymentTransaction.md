# UC4 - Create Payment Transaction

## 1. Requirements Engineering

### Brief Format

The organization's collaborator starts the creation of a payment transaction of a finished/executed task. The system requests the necessary data on the payment transaction, that is, a brief description of the task (id, brief description, time duration (in hours), cost per hour (in euros) and task category), details about the execution of the task (end date, delay, brief description of the quality of the work) and information about the freelancer that worked on the task (id, name, level of expertise, e-mail, NIF, bank account (IBAN), address and country). The organization's collaborator enters the requested data. The system validates and displays the payment transaction data and also the amount to pay to each freelancer, asking for confirmation. The organization's collaborator confirms. The system records the payment transaction data and informs the organization's collaborator of the success of the operation.

### SSD
![UC3_SSD.svg](UC3_SSD.svg)


### Complete Format

#### Main Actor

Organization's Collaborator

#### Interesting parts and their interesses
* **Organization's Collaborator:** intends to create payment transactions for Freelancers.
* **Freelancer:** wants a payment transaction to be created for himself.
* **T4J:** allows the organization's collaborator to create payment transactions for Freelancers.


#### Preconditions
n/a

#### Postconditions
The information about the payment transaction is saved in the system.

#### Main success scenario (or basic flow)

1. The organization's collaborator starts the creation of a payment transaction of a finished/executed task. 
2. The system requests the necessary data on the payment transaction, that is, a brief description of the task (id, brief description, time duration (in hours), cost per hour (in euros) and task category), details about the execution of the task (end date, delay, brief description of the quality of the work) and information about the freelancer that worked on the task (id, name, level of expertise, e-mail, NIF, bank account (IBAN), address and country). 
3. The organization's collaborator enters the requested data.
4. The system validates and displays the payment transaction data and also the amount to pay to each freelancer, asking for confirmation.
5. The organization's collaborator confirms.
6. The system records the payment transaction data and informs the organization's collaborator of the success of the operation. 

#### Extensions (or alternative flows)

*a. the organization's collaborator requests to cancel the creation of the payment transaction.

> The use case ends.

4a. Task description data incomplete.
>	1. The system informs which data is missing.
>	2. The system allows the entry of missing data (step 3)
>
	>	2a. The organization's collaborator does not change the data. The use case ends.

4b. Incomplete task execution details.
>	1. The system informs which data is missing.
>	2. The system allows the entry of missing data (step 3)
>
	>	2a. The organization's collaborator does not change the data. The use case ends.

4c. incomplete data about the freelancer who worked on the task.
>	1. The system informs which data is missing.
>	2. The system allows the entry of missing data (step 3)
>
	>	2a. The organization's collaborator does not change the data. The use case ends.
	
4d. Missing minimum required data.
>	1. The system informs which data is missing.
>	2. The system allows the entry of missing data (step 3)
>
	>	2a. The organization's collaborator does not change the data. The use case ends.

4c. The system detects that the data (or a subset of the data) entered does not exist in the system.
>	1. The system alerts the collaborator of the organization to the fact.
>	2. The system allows the creation of these missing data (transition to use cases 1 (create freelancer) and 2 (create task)).
>
	>	2a. the organization's collaborator does not create the data. The use case ends.


#### Special requirements
\-

#### List of Technologies and Data Variations
\-

#### Frequency of Occurrence
\-

#### Open questions

* Are there any other mandatory data in addition to those already known?
* How often does this use case occur?


## 2. OO Analysis

### Excerpt from the Relevant Domain Model for UC

![UC3_MD.png](UC3_MD.png)


## 3. Design - Use Case Realization

### Rational

| Main Flow | Question: What Class ... | Answer  | Justification  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
|1. The organization's collaborator starts the creation of a payment transaction of a finished/executed task.|... interact with the user?| CreatePaymentTransactionUI |Pure Fabrication|
| |... coordinates the UC?| CreatePaymentTransactionController |Controller|
| |... create payment transaction instances?|Plataforma|Creator(regra1)|
|2. The system requests the necessary data on the payment transaction, that is, a brief description of the task (id, brief description, time duration (in hours), cost per hour (in euros) and task category), details about the execution of the task (end date, delay, brief description of the quality of the work) and information about the freelancer that worked on the task (id, name, level of expertise, e-mail, NIF, bank account (IBAN), address and country).||||
|3. The organization's collaborator enters the requested data. |... guarda os dados introduzidos?|Organizacao, EnderecoPostal, Colaborador|IE: instância criada no passo 1|
| |... cria instâncias de EnderecoPostal?|Organizacao|creator(regra1)|
| |... cria instâncias de Colaborador?|Organizacao|creator(regra1)|
|4. The system validates and displays the payment transaction data and also the amount to pay to each freelancer, asking for confirmation. |... valida os dados da Organizacao (validação local)|Organizacao|IE: possui os seus próprios dados|
| |... valida os dados da Organizacao (validação local)|EnderecoPostal|IE: possui os seus próprios dados|
| |... valida os dados da Organizacao (validação local)|Colaborador|IE: possui os seus próprios dados|
| |... valida os dados da Organizacao (validação global)|Plataforma|IE: A Plataforma tem registadas Organizacao|
|5. The organization's collaborator confirms. ||||
|6. The system records the payment transaction data and informs the organization's collaborator of the success of the operation. |... guarda a Organizacao criada?| Plataforma |IE: No MD a Plataforma tem  Organizacao|
| |... regista/guarda o Utilizador referente ao Colaborador da Organizacao?|AutorizacaoFacade|IE. A gestão de utilizadores é responsabilidade do componente externo respetivo cujo ponto de interação é através da classe "AutorizacaoFacade"|

             

### Systematization ##

It follows from the rational that the conceptual classes promoted to software classes are:

 * Plataforma
 * Organizacao
 * Colaborador
 * EnderecoPostal


Other software classes (i.e. Pure Fabrication) identified:

 * CreatePaymentTransactionUI  
 * CreatePaymentTransactionController


###	Sequence Diagram

![UC3_SD.svg](UC3_SD.svg)



###	Class Diagram

![UC3_CD.svg](UC3_CD.svg)

