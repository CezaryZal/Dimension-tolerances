# DIMENSION TOLERANCES

### Description

The application is a metrological calculated to get an upper and lower deviation of 
the entered dimension. It is very useful for constructors of industrial machines.

The algorithm calculates deviations based on the tables `basic_deviations`, 
`nominal_tolerance` and `addition_table_to_basic_deviations`.

#### Creation purpose

The project was created on the request from previous work colleagues, because
most of the dimensions were calculated manually.

#### Usage

To use the calculator, open the web application by choosing the following *link*.
//screenShot

Then enter the dimension from which you would like to get the upper and lower deviation.
After pressing the enter or 'CALCULATE' button you will get the result.
For example, enter 52g7 dimension you get....

## Applied technologies
Backend:
- Maven
- Spring Framework
- Hibernate
- REST API
- Lombok (to get logs)
- application container Tomcat

Frontend:
- HTML
- CSS
- Typescript

## To do list
- [ ] add valid input 
- [x] use design patterns
- [ ] add tests
- [ ] add exception handling