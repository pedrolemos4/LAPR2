UC1 - Create Freelancer

## 1. Requirements engineering

### Breef Format


The collaborator starts to create a new Freelancer. The system asks needed information (i.e. id, name, level of expertise, e-mail, NIF, bank account (IBAN), address and country). The collaborator introduces the information. The system validates and apresents the information to the collaborater, asking for confirmation. The collaborator confirms. The system regists the information and informs the collaborator about the sucess of the operation.

### SSD
![UC1_SSD.jpg](UC1_SSD.jpg)


### Full Format

#### Ator principal

Administrativo

#### Partes interessadas e seus interesses
* **Collaborator:** pretends to create a new freelancer for a task.
* **T4J:** pretends the collaborator associats a new freelancer to a task.
* **Freelancer:** pretends to be registed in the system.


#### Pré-condições
/-

#### Pós-condições
The freelancer stays in the system.

### Cenário de sucesso principal (ou fluxo básico)

1. The collaborator starts to create a new Freelancer. 
2. The system asks needed information (i.e. id, name, level of expertise, e-mail, NIF, bank account (IBAN), address and country). 
3. The collaborator introduces the information. 
4.The system validates and apresents the information to the collaborater, asking for confirmation. 
5. The collaborator confirms. 
6. The system regists the information and informs the collaborator about the sucess of the operation.



#### SSD
![UC3_SSD2.png](UC3_SSD2.png)


#### Extensions (or alternative fluxes)

*a. The collaborator cancels the registration

> Case of use ends.

4a. Minimal information missing.
>       1. The system informs which information is missing.
>       2. The system allows introducing the missing information (step 3)
>
        >       2a. The collaborator doesn´t add information. The case of use ends.

4b. The systems detects the information (or any amount of information) introduces must be unique and already exists in the system.
>       1. The system alerts the collaborator for the fact.
>       2. The system allows the changing (step 3).
>               
        >2a. The collaborator does not change anything. The use case.

4c. The system detects the information introduced (or any amount of information) are invalid.
>       1. The system alerts the collaborator for the fact.
>       2. The system allows the changing (step 3).
>
        > 2a. The collaborator does not change anything. The use case.

      
#### Special Requirements
\-

#### List of Technologies and Data Variations
\-

#### Frequency of Occurrence
\-

#### Open Questions

* Exists other data needed?
* Are all data mandatory?
* How frequently this use case occurs?

## 2. OO Analysis

### Excerto do Modelo de Domínio Relevante para o UC

![UC1_MD.png](UC1_MD.png) 


## 3. Design - Realization of Use Case

### Racional

| Main Flow | Question: Which class... | Answer | Justification |
|:--------------  |:---------------------- |:----------|:---------------------------- |
| 1. The collaborator starts to create a new Freelancer. |  |  |  | 
| 2. The system asks needed information (i.e. id, name, level of expertise, e-mail, NIF, bank account (IBAN), address and country). |  |  |  |  
| 3. The collaborator introduces the information. |  |  |  | 
| 4.The system validates and apresents the information to the collaborater, asking for confirmation. |  |  |  |  
| 5. The collaborator confirms. |  |  |  | 
| 6. The system regists the information and informs the collaborator about the sucess of the operation. |  |  |  | 


### Systematization ##

 From the racional results the conceptual classes promoted to software classes are : 
 
 * Plataforma
 * CategoriaTarefa


 The other software classes (i.e. Pure Fabrication) identify:

 * DefinirCategoriaUI
 * DefinirCategoriaTarefaController  


###     Sequence Diagram
 
![UC1_SD.png](UC1_SD.png)


###     Class Diagram

![UC1_CD.png](UC1_CD.png)