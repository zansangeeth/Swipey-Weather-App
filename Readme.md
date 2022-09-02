<h1 align="center">Swipey-Weather-App</h1>

 
<h3 align="center">Sangeeth Amirthanathan</h3>

<br>
**Swipey-Weather-App** is an App that will display weather details of user entered location.

<br>Time spent: *1* day spent in total

## Android MVVM Architecture

MVVM stands for Model, View, ViewModel.

* [ ] Model: This holds the data of the application. It cannot directly talk to the View. Generally, it’s recommended to expose the data to the ViewModel through Observables.

* [ ] View: It represents the UI of the application devoid of any Application Logic. It observes the ViewModel.

* [ ] ViewModel: It acts as a link between the Model and the View. It’s responsible for transforming the data from the Model. It provides data streams to the View. It also uses hooks or callbacks to update the View. It’ll ask for the data from the Model.

The following flow illustrates the core MVVM Pattern.

![android-mvvm-pattern](https://user-images.githubusercontent.com/42418189/186920956-39430cc6-9eab-4b5a-86fc-c9cba4b72e3b.png)

## Retrofit

Retrofit is a REST Client for Java and Android allowing to retrieve and upload JSON (or other structured data) via a REST based You can configure which converters are used for the data serialization, example GSON for JSON.

To work with Retrofit you basically need the following three classes:

* [ ] Model class which is used as a JSON model

* [ ] Interfaces that define the possible HTTP operations

* [ ] Retrofit.Builder class - Instance which uses the interface and the Builder API to allow defining the URL end point for the HTTP operations.


## Functionality 

The following **required** functionality is completed:

* [ ] Activities
* [ ] Lifecycle
* [ ] Activity Navigations
* [ ] Data tranfer within Activities
* [ ] Material UI - https://m3.material.io/
* [ ] Retrofit - https://square.github.io/retrofit/
* [ ] Coroutines
* [ ] Dark Mode
* [ ] MVVM

The following **extensions** are implemented:

* [ ] User can enter the Location
* [ ] User can get weather details for the specific location
* [ ] if user enetered a wrong location that not stored in the remote web server user will navigate to no-search-results found screen


## Video Walkthrough

Here's a walkthrough of implemented user stories:

![20220902_113547 (1)](https://user-images.githubusercontent.com/42418189/188071396-f5ba9b5d-28ce-4d1d-9ea0-38e88175f75f.gif)


# Screenshots
Screen | #1 | #2 | #3 |
--- | --- | --- | --- |
Imaages | ![Screenshot_20220902-113937](https://user-images.githubusercontent.com/42418189/188070481-f7189131-4f53-45f1-9d04-f205f7ab00d1.png) | ![Screenshot_20220902-114012](https://user-images.githubusercontent.com/42418189/188070534-8a153ea4-1320-47d2-8323-db131fa352f6.png) | ![Screenshot_20220902-114000](https://user-images.githubusercontent.com/42418189/188070661-b62a1d8b-8ab2-4361-ac43-eae22efeb56c.png) |


## Notes

Describe any challenges encountered while building the app.

* [ ] Navigating Activities
* [ ] Passing data between Activities
* [ ] Dealing with build.gradle
* [ ] Designing Application in XML
* [ ] Design UI
* [ ] Deal with retrofit
* [ ] Deal with data classed and JSON objects classws


## License

    Copyright 2022 Sangeeth Amirthanathan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.





 
