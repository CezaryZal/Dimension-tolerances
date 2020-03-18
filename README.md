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

To use the calculator, open the web application by choosing the following 
*[Dimension-tolerances](http://164.132.97.42:8081/dimension-tolerances/)*.
![Screenshot of main_view](https://raw.githubusercontent.com/CezaryZal/Dimension-tolerances/master/src/main/web/screenshots/ScreenshotFromDimensionTolerances.png)
###### View of the main page

___

Then enter the dimension from which you would like to get the upper and lower deviation.
After pressing the enter or 'CALCULATE' button you will get the result.
For example, enter 52g7 dimension you get....

## Applied technologies
Backend:
- Maven
- Spring Framework
- Hibernate
- REST API
- JUnit
- Lombok (to get logs)
- application container Tomcat

Frontend:
- HTML
- CSS
- Typescript

## To do list
- [x] add valid input 
- [x] use design patterns
- [x] add exception handling (backend)
- [x] add tests
- [ ] add exception handling (frontend)

