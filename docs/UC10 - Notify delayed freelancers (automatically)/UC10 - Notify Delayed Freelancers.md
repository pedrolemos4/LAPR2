UC10 - Notify Delayed Freelancers (automatically)

## 1. Requirements Engineering

### Breef Format

The system inicializes the process of notification in the last day of each year. The system **register the data** and ends the process.


### SSD
![UC10_SSD.png](UC10_SSD.png)


### Full Format

#### Main Actor

* Timer

#### Interested parts and his interest
* **T4J:** wants that the Freelancer stays informed by the system.
* **Freelancer:** gets informed by the system.


#### Conditions before
/-

#### Conditions after
The freelancer stays informed.

### Main sucess scene (Basic flux)

1. The system starts the process of notification in the last day of every year.
2. The system identifies the freelancers that have mean task delay higher than 3 hours and have a percentage of delays higher than the overall percentage of delays. After that, starts the notification of the freelancers.


#### Extensions (or alternative fluxes)

*2a. There are no freelancers.
> Use case ends.

*2b. The freelancers have no task delay.
> Use case ends.

*2c. There is no freelancer that has task delay time higher than 3 hours
> Use case ends.
      
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

![UC10_MD.png](UC10_MD.png) 


## 3. Design - Realization of Use Case

### Racional

| Main Flow | Question: Which class... | Answer | Justification |
|:--------------  |:---------------------- |:----------|:---------------------------- |
| 1. The collaborator starts to create a new Freelancer. | ...coordinates the UC? | NotifyFreelancersTask | Task |
|                                                        | ...starts the process of notification? | Timer | Timer |
|                                                        | ...creates the instance Timer? | Plataform | Creator: Plataform as knowledge of the time to start the notifications. |
| 2. The system identifies the freelancers that have mean task delay higher than 3 hours and have a percentage of delays higher than the overall percentage of delays. After that, starts the notification of the freelancers. | ...knows the task delay? | ExecutionOfTheTask | IE: Knows its own information |  
|  | ...knows the percentage of delays | ExecutionOfTheTask | IE: knows its own information  |


### Systematization ##

 From the racional results the conceptual classes promoted to software classes are : 
 
 * Plataform


 The other software classes (i.e. Pure Fabrication) identify:

* NotifyFreelancersTask
* Timer


###     Sequence Diagram
 
![UC10_SD.png](UC10_SD.png)


###     Class Diagram

![UC10_CD.png](UC10_CD.png)
