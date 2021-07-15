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

- SpringApp_Autowired - _**Внедрение зависмостей (Dependency Injectiin)**_ в приведённом примере рассматривалась аннотация **_Autowired_** и её основные свойства

![Annotation_Autowired](https://user-images.githubusercontent.com/61631173/125503187-aa35eb0b-280e-47ac-8801-a44010fdd5f5.JPG)</p>

![Annotation_Autowired_как работает](https://user-images.githubusercontent.com/61631173/125504564-d61c18ca-2fbe-45f4-8e5c-4fd4696f5314.JPG)</p>

![Annotation_Autowired_ещё об](https://user-images.githubusercontent.com/61631173/125550365-5640c2b8-03d3-4827-8633-7ed26147096c.JPG)</p>

![Annotation_Autowired_ещё об 1](https://user-images.githubusercontent.com/61631173/125550367-13480f64-2e8b-43b1-b6ae-27c02b6ce1b7.JPG)</p>

![Annotation_Autowired_ещё об 2](https://user-images.githubusercontent.com/61631173/125550369-437c9536-2998-4c92-b6dc-57c4c94d63c7.JPG)

Рассмотрение @Autowired в коде...

в классе MusicPlayer поставлена @Autowired

![пример @Autowired_MusicPlayer](https://user-images.githubusercontent.com/61631173/125554770-c5d62a7d-89d4-460f-ad4f-14dc0625e89d.JPG)</p>

проверка выпонения в консоли
![пример @Autowired_TestSpring](https://user-images.githubusercontent.com/61631173/125555178-749b9b8d-6af6-4227-9d0f-9721cc42cba5.JPG)</p>
Ситуация, когда Spring не найдёт нужный Бин для внедрения в MusicPlayer, для этого убрали @Component  перед классом ClassicalMusik:
![пример @Autowired_MusicPlayer_ без @Component](https://user-images.githubusercontent.com/61631173/125554765-90399b95-2526-46fe-a49e-770b39323cd0.JPG)</p>
...таким образом у Spring не будет Бина, который подходит для конструктора public MusicPlayer(ClassicalMusic classicalMusic) класса MusicPlayer</p>
Проверка выпонения в классе TestSpring без @Component перед классом ClassicalMusik:rage1:
![пример @Autowired_TestSpring_ошибка выполнения_что ожидается Бин](https://user-images.githubusercontent.com/61631173/125554769-476a98e6-02ef-468f-a03f-52fbfd42dcb0.JPG)</p>

... исправим приватное поле в классе MusicPlayer c класса ClassicalMusic на интерфейс Music, тем самым мы Spring, что хотим внедрить тот Бин, который реализует интерфейс Music.
![пример @Autowired_MusicPlayer_ без @Component_параметр конструктора MusicPlayer интерфейс Music](https://user-images.githubusercontent.com/61631173/125557859-c585dfcc-472d-4c38-a462-e0418fbbeac0.JPG)</p>
... как можно убедиться, в Spring внедрён Бин Music и MusicPlayer играет рок музыку. </p>
При вернуть обратно @Component в класс ClassicalMusic, то получится неоднозначность, т.к. по условию конструктора public MusicPlayer(Music music) проходит Бин ClassicalMusic и RockMusic и они оба реализуют интерфейс Music. </p> Результатом выполнения будет ошибка. :rage1: </p>
![пример @Autowired_TestSpring_ошибка выполнения_неоднозначность, реализация интерфейса несколькими Бинами](https://user-images.githubusercontent.com/61631173/125559430-82123d76-522f-4e8f-aa7e-41bd0e311f6c.JPG)</p>

Внедрение @Autowired через Setter:👍  </p>
![пример @Autowired_MusicPlayer_ через Setter](https://user-images.githubusercontent.com/61631173/125560101-495a3db1-1b91-4cfc-b160-295c330f42ed.JPG)

Spring все равно как называется метод, он находит название интерфейса (класса) и все равно внедрит зависимость используя данный метод.
Внедрение @Autowired через поле:👍  </p>
![пример @Autowired_MusicPlayer_ через поле](https://user-images.githubusercontent.com/61631173/125560643-131774da-3be2-48ab-9c07-4e6776e1880b.JPG)</p>

Внедрение @Autowired через конструктор с параметрами классов ClassicalMusic и RockMusic:👍  </p>
![пример @Autowired_MusicPlayer_ с добавлением конструктора класса MusicPlayer  с параметрами классов ClassicalMusic RockMusic и введением @Componetn в класс ClassicalMusic](https://user-images.githubusercontent.com/61631173/125562953-7b76ea20-7f38-4469-b9a0-5301dac2eeaa.JPG)</p>
Внедрение зависимостей Spring-ом внутри других зависимостей:👍  </p>
Создание дополнительного клсса Computer:👍  </p>
![пример @Autowired_MusicPlayer_ с добавлением класса Computer_класс Computer](https://user-images.githubusercontent.com/61631173/125569130-b9bfc5de-4e53-47e7-b960-929b8fe7bcc2.JPG)</p>

.... изменения в классе MusicPlayer:👍  </p>
![пример @Autowired_MusicPlayer_ с добавлением класса Computer](https://user-images.githubusercontent.com/61631173/125569128-5765b567-b6a5-4374-ad1b-7f25c89ef3af.JPG)</p>

.... создание экземпляра в классе TestSpring:👍  </p>
![пример @Autowired_MusicPlayer_ с добавлением класса Computer_класс TestSpring](https://user-images.githubusercontent.com/61631173/125569123-41b38af8-efeb-447c-91a4-18bac0a6e1b6.JPG)</p>

_ _ _ _ 

- SpringApp_Qualifier </p>
Пример, в котором решается проблема вывода значений 2-х классов совместно использующих один интерфейс.</p>
![Проблема](https://user-images.githubusercontent.com/61631173/125617340-51af99a8-da42-4983-aa78-e218f1c99c7d.JPG)</p>
![@Qualifier](https://user-images.githubusercontent.com/61631173/125617444-22e86397-0cd2-4966-8534-387100fb042a.JPG)</p>
![@Qualifier_необычный синтаксис](https://user-images.githubusercontent.com/61631173/125617481-c0424e0e-1c5f-4ca2-ba26-da412dfc9ee3.JPG)</p>
![@Qualifier_пример_MusicPlayer](https://user-images.githubusercontent.com/61631173/125617525-38df1279-b361-4f6d-ac1e-54019782147f.JPG)
Немного исправив прошлый код, по примеру полученному выше, получаем вывод значений в консоли...
![@Qualifier_пример_введение аннотации к каждому параметру в конструкторе](https://user-images.githubusercontent.com/61631173/125617527-86a55a97-8fae-476b-be72-6189739c3ae3.JPG)
После всего проделоного и изученого, можно выполнить самостоятельно задание на пройденную тему
![Задание_@Qualifier](https://user-images.githubusercontent.com/61631173/125617529-90a6d365-c7c2-4158-b7cf-893b7d8fe587.JPG)

![ClassicalMusic](https://user-images.githubusercontent.com/61631173/125629161-9c616232-91cf-4e43-ae5e-3d3e062a4e1a.JPG)

![MusicPlayer](https://user-images.githubusercontent.com/61631173/125629163-adeb6877-7221-4486-b88d-28851422990d.JPG)

![Musik_интерфейс](https://user-images.githubusercontent.com/61631173/125629164-3c497ead-6e64-4505-9c86-ee5e954664c8.JPG)

![TestSpring](https://user-images.githubusercontent.com/61631173/125629165-43bd4adf-a2b4-4a19-b88b-d34d6c66badf.JPG)
_ _ _ _ 

- SpringApp_@Scope_@Value_@PostConstructor_PreDestroy</p>
Здесь рассмотрим внедрение внешних значений при помощи @Value, область видимости Бинов @Scope и жизненный цикл Бина @PostConstruct_@PreDestroy вместо xml кнфигураций.</p>
![внедрение внешних значений при помощи xml](https://user-images.githubusercontent.com/61631173/125738037-67d8a8d2-39f0-4a4e-ba8b-cd2712adf066.JPG)

![внедрение внешних значений при помощи @Value](https://user-images.githubusercontent.com/61631173/125738089-4198c885-3bb3-46cc-a2b3-0496bbc20970.JPG)</p>
Демонстрация на примере...
![пример_Value_musicPlayer properties](https://user-images.githubusercontent.com/61631173/125784801-30824104-83ff-41f1-82d7-2ed61fd996f7.JPG)

![пример_MusicPlayer](https://user-images.githubusercontent.com/61631173/125784822-af6fdf81-f8e5-4ebf-be2b-de3ba1c9aec5.JPG)

![пример_TestSpring](https://user-images.githubusercontent.com/61631173/125784852-502a34fb-d5cc-4c68-900a-bcc69427f2fe.JPG)

![Область видимости Бинов_Scope_xml](https://user-images.githubusercontent.com/61631173/125738146-9aa4ef26-a6cd-4624-896c-7568b7304617.JPG)

![Область видимости Бинов_Scope_Singleton vs  Prototype](https://user-images.githubusercontent.com/61631173/125738229-766cbc81-6b60-47ac-8304-9a46d98ab14d.JPG)

![Область видимости Бинов_@Scope](https://user-images.githubusercontent.com/61631173/125738287-a322f463-6871-4ab1-9648-555e58042ca0.JPG)</p>

Демонстрация области видимости на примере:
![пример_Scope_singleton_ClassicalMusic](https://user-images.githubusercontent.com/61631173/125790937-e63099e5-56ad-4876-91eb-2537ade1d6ec.JPG)</p>
проверка @Scope "singleton". Проверка объектов в главном классе, значение true, говорит о том что объекты одинаковы, подтвержение того что Scope singleton сработал правильно.
![пример_Scope_singleton_TestSpring](https://user-images.githubusercontent.com/61631173/125792540-08dcba53-cad6-46d7-b71a-c486505f685e.JPG)</p>
Демонстрация @Scope "prototype" вместе с выводом в консоли false
![пример_Scope_prototype_ClassicalMusic](https://user-images.githubusercontent.com/61631173/125791160-9afdc2bf-0d2a-432e-9974-33f36e321047.JPG)

![жизненный цикл Бина](https://user-images.githubusercontent.com/61631173/125738332-d6a66891-4f9e-4ee5-8e7f-ff3b6420348f.JPG)

![жизненный цикл Бина_методы](https://user-images.githubusercontent.com/61631173/125738406-46f8e669-0d93-4b4f-9402-04f0f0910dd3.JPG)

![жизненный цикл Бина_@PostConstruct_@PreDestroy](https://user-images.githubusercontent.com/61631173/125738557-483b91cc-7cd1-4d53-8a72-226c6ed78577.JPG)

![жизненный цикл Бина_пример_@PostConstruct_@PreDestroy](https://user-images.githubusercontent.com/61631173/125738488-4358f829-7f86-4964-852b-93bb8343965e.JPG)

![жизненный цикл Бина_сигнатура_@PostConstruct_@PreDestroy](https://user-images.githubusercontent.com/61631173/125738614-f55834dd-7b2e-4fd7-b649-31be7f266bc3.JPG)

