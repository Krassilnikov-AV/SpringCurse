# SpringCurse
_ _ _ _ 
- SpringApp1 - простейшее приложение с использованием Spring Core
1) Добавление зависимотей в pom.xml 
2) Создание директорий resources и java с пометкой Resources Root
3) Создание Java классов TestBean и TestSpring
4) Создание applicationContext.xml
_ _ _ _
- SpringApp_IoC

конфигурация Spring с помощью xml.
На примере музыкального плеера рассматривается  внедрение инверсии управления Inversion of Control (IoC)
1) создание интерфейса Music
2) создание Java классов ClassikMusic и RockMusic, которые переопределяют интерфейс Music
3) создание Java классов ClassikPlayer в котором внедряем зависимость IoC путём создания конструктора, который получает параметр интерфейса и выводит в консоль проинрываемое значение
4) В applicationContext.xml вызывается Бин по направлению музыки.
_ _ _ _
- SpringApp_DI

В IoC внедрение зависимости производили вручную через Бин Musik. Для избежания создания ручного внедрения зависимости, в данном приложении используется Dependency Injection (DI), через конструктор с использованием xml.
1) В applicationContext.xml создаётся ещё один Бин с id = musicPlayer и указанием пути с конструктором, ссылающимся на уже созданный Бин.
2) При получении Бина MusicPlayer из applicationContext.xml он будет с внедрённой зависимостью. Таким образом не нужно обращаться к интерфейсу Music и создавать вручную экземпляр MusicPlayer.
3) В TestSpring создаётся обращение к контексту через параметры musicPlayer и таким образом можно менять в пути Бина название класса, который будет выводить результат в консоли. Тем самым при помощи Spring была внедрена зависимость, которая и называется DEPENDENCY INJECTION.
_ _ _ _
- SpringApp_DI_Setter - внедрение зависимостей ч/з _Setter_

В приложении SpringApp_DI  внедрение зависимостей происходит ч/з конструктор _<constructor-arg....../>_, а в приложении **_SpringApp_DI_Setter_** происходит при помощи метода _setter_:
1) создание метода _setMusic_ в классе _MusicPlayer_, который в кач-ве параметра принимает значение интерфейса _music_
2) в _xml_ файле используется тэг _property_ для передачи ему зависимости _musicBean_

Таким образом данное приложение позволяет внедрять значения из внешнего файла, что позволяет не редактировать файл _xml_.
**ЗАДАНИЕ**
- Доработать таким образом, чтобы добавлялась коллекция музыки
_ _ _ _
- SpringApp_Scopes<p>В данном проекте опробованы два скопа <em>singleton</em> и <em>prototype</em></p>
При определении bean в Spring Framework, у нас есть возможность объявить область видимости этого компонента.</p>
В Spring Framework имеются пять возможных значений свойства scope, в данном примере рассматривается два скопа
В Spring предусмотрены различные области времени действия би-нов:
1)	**_singleton_** - может быть создан только один экземпляр бина. Этот тип используется спрингом по умолчанию, если не указано другое. Следует осторожно использовать публичные свойства класса, т.к. они не будут потокобезопасными.
2)	**_prototype_** - создается новый экземпляр при каждом запросе.
_ _ _ _ 
- SpringApp_InitDestroyAndFactory </p>
B примере рассматривается жизненный цикл бина, при помощи создания методов public static ClassicalMusic getClassicalMusic() (особого фабричного метода), возвращающим экземпляр ClassicalMusic, метода public  void doMyInit() и public  void doMyDestroy() и прописанием методов в applicationContext.xml</p> В консоли выведится порядок вызываемых методов, что и покажет жизненный цикл Бина.</p>
Основные особенности  **_init_** и **_destroy_** методов</p>
1. **Модификатор доступа** - у данных методов может быть любой модификатор (_public, protected, private_)
2. **Тип возвращаемого значения** - может быть любой, но чаще всего используется _void_ (т.к. нет возможности получить возвращаемое значение).
3. **Название метода** - название может быть любым
4. **Аргументы метода** - эти методы **не должны** принимать на вход какие - либо аргументы</p>
Одна важная особенность бинов со scope - **_"prototype"_** Spring **не вызывает destroy метод.**</p>
- Spring не берет на себя полный жизненный цикл бинов со scope _"prototype"_. Spring отдаёт _prototype_ бины клиенту и больше о них не заботится (в отличии от singleton бинов).</p>
ЗАДАНИЕ: </p>
- убедиться что  Spring не вызывает destroy метод при scope _"prototype"_.
- посмотреть сколько раз вызывается _init-method_, если мы получаем несколько prototype бинов.</p>
ОТВЕТы:
- при scope _"prototype"_ не вызывается destroy метод;
-  _init-method_ вызовется каждый раз при каждом создании экземпляра класса.</p>
При создании нескольких объектов класса, при factory-method="getClassicalMusic" (Фабрики) инициализация осуществляется только один раз. В даном примере показано это свойство</p>
_ _ _ _
- SpringApp_AnnotationStart</p>
![Аннотации](https://user-images.githubusercontent.com/61631173/125491644-23f68041-f9df-4c0a-acf7-b953805ad84e.JPG)</p>
![зачем аннотации](https://user-images.githubusercontent.com/61631173/125492055-b7366dfd-238c-4799-979f-db73f0424dfb.JPG)</p>
![как работает конфигурация с помощью аннотации](https://user-images.githubusercontent.com/61631173/125492630-9ccb877a-016b-4e87-a9b8-8470ede2bbbb.JPG)</p>
![Аннотация_Component](https://user-images.githubusercontent.com/61631173/125493095-b4e826ba-4f56-4747-a430-826d1823f59b.JPG)
</p>
- В данном примере ввели следующую строку в applicationContext.xml

 ![applicationContext](https://user-images.githubusercontent.com/61631173/125494840-e6ec6226-caa8-4c19-8149-cfbe44a95dea.JPG)
 
 где указан пакет, в котором Spring будет сканировать и искать все классы с аннотаией Component, при нахождении определённой аннотации будет созlан Бин из этого класса.</p>
 В приведённом примере отработана аннотация Component, которая была введена перед классами RockMusic и ClassicalMusik 
 
 ![RockMusic_Component](https://user-images.githubusercontent.com/61631173/125497544-61966318-19f5-47b5-b85e-6b269fc3c9bf.JPG)
 
  @Component  перед классом RockMusic 
  
  ![ClassicalMusic_Component](https://user-images.githubusercontent.com/61631173/125497554-ddd99003-9dc0-47f8-b886-1279077bef17.JPG)
  
  @Component  перед классом ClassicalMusik 
 
 В тестовом классе создано два экземпляра разных классов для демонстрации вывода в консоли результатов:
 
![TestSpring_Component](https://user-images.githubusercontent.com/61631173/125497551-4007f8fd-2262-45c6-9fcf-5e5d88e4fc7f.JPG)
</p>

_ _ _ _

- SpringApp_Autowired, в приведённом примере рассматривалась аннотация **_Autowired_** и её основные свойства

![Annotation_Autowired](https://user-images.githubusercontent.com/61631173/125503187-aa35eb0b-280e-47ac-8801-a44010fdd5f5.JPG)</p>

![Annotation_Autowired_как работает](https://user-images.githubusercontent.com/61631173/125504564-d61c18ca-2fbe-45f4-8e5c-4fd4696f5314.JPG)</p>

![Annotation_Autowired_ещё об](https://user-images.githubusercontent.com/61631173/125550365-5640c2b8-03d3-4827-8633-7ed26147096c.JPG)</p>

![Annotation_Autowired_ещё об 1](https://user-images.githubusercontent.com/61631173/125550367-13480f64-2e8b-43b1-b6ae-27c02b6ce1b7.JPG)</p>

![Annotation_Autowired_ещё об 2](https://user-images.githubusercontent.com/61631173/125550369-437c9536-2998-4c92-b6dc-57c4c94d63c7.JPG)

