# SpringCurse</p>
_В репозитории вкратце рассмотрены основные вопросы **фреймворка Spring** c примерами их реализации.</p>
курс представлен на Ютуб канале https://www.youtube.com/playlist?list=PLAma_mKffTOR5o0WNHnY0mTjKxnCgSXrZ  Наилем Алишевым_
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

Демонстрация жизненного цикла Бина на примере ....
![пример_PostConstruct_PreDestroy_ClassicalMusic](https://user-images.githubusercontent.com/61631173/125793238-8ae25128-7baa-48ce-a3b2-9490f067a85c.JPG)</p>
_ _ _ _ _ _ 

- **SpringApp_Config_JavaCode** </p>
В данном примере рассматривается замена конфигураций xml файлов на Java Code</p>

![1_список конфигураций](https://user-images.githubusercontent.com/61631173/125938623-0306c307-5a00-4a0c-a078-c40a1d8d8463.JPG)

![2_Annotation Configuration in Java](https://user-images.githubusercontent.com/61631173/125938624-d9acda61-17ba-4bd8-b62b-c5e026725f6f.JPG)

![3_xml тег = соответствующая аннотация](https://user-images.githubusercontent.com/61631173/125938620-5e1d6856-b356-4c53-a56a-c3938871b7ca.JPG)

![3_тег = аннотация](https://user-images.githubusercontent.com/61631173/125938621-0b720d9b-e2a8-48aa-8547-be2bff9a0272.JPG)

![4_использование конфигурационного файла](https://user-images.githubusercontent.com/61631173/125938661-cb043277-324f-4a01-a034-f9fb275f7960.JPG)

![5_ручное внедрение зависимостей без Autowired](https://user-images.githubusercontent.com/61631173/125938662-34406133-6ce6-4c0c-af0d-fb2ffd72707c.JPG)

![6_Подробнее об аннотации Bean](https://user-images.githubusercontent.com/61631173/125938663-cf6f983f-a92b-41bf-a10b-993c8d52f366.JPG)

![7_Внедрение зависимостей из внешнего файла_раньше](https://user-images.githubusercontent.com/61631173/125938664-03528a5b-165f-45f0-816c-142e6a1138b2.JPG)

![7_Внедрение зависимостей из внешнего файла_теперь](https://user-images.githubusercontent.com/61631173/125938659-996aa030-f2cd-49c2-8a00-6398e9ab71fb.JPG)

Выполнение всех перечисленных аннотациий проработаны в коде...
![пример_1_создание конфигурационного класса эквивалента xml файла конфигураций](https://user-images.githubusercontent.com/61631173/125945663-0296738e-eb5c-4423-a786-9e13469f77a3.JPG)
После создания Java класса конфигурации, данный xml файл успешно удаляется</p>
![пример_2_файл xml под удаление после создания Java класса конфигурации](https://user-images.githubusercontent.com/61631173/125945665-cb87c9fa-53d8-483b-ba9b-01fed6da74da.JPG)

![пример_3_удаление загрузочного класса файл xml](https://user-images.githubusercontent.com/61631173/125945658-af0f78ed-c76c-4c2d-a0a3-73c9513e5d2a.JPG)

![пример_4_создание нового экземпляра загрузочного класса вместо экземпляра файла xml с результатом выполнения](https://user-images.githubusercontent.com/61631173/125945659-8674d90c-4916-4bd1-b495-a33c9853ad69.JPG)

![пример_5_заполнение конфигурационного класса SpringConfig аннотациями для классов с запуском для проверки](https://user-images.githubusercontent.com/61631173/125945662-8c7bc63e-5798-496e-8e68-93aa2c7be6dc.JPG)

_ _ _ _ 
**<h1>Spring MVC</h1>**</p>
![1_Обзор курса](https://user-images.githubusercontent.com/61631173/125952487-d37e4d20-c6d6-41b8-9a45-baac51363b90.JPG)

![2_Spring MVC_ определение](https://user-images.githubusercontent.com/61631173/125952500-b199e242-99ab-4206-bc5d-918711603e3c.JPG)

![3_Spring MVC - структура](https://user-images.githubusercontent.com/61631173/125952507-a9208dc9-17fe-4a71-8835-799bf96ca3d2.JPG)

![4_состав Spring MVC](https://user-images.githubusercontent.com/61631173/125952510-aef64b64-4c49-48f3-9a6d-6ce554ce719b.JPG)

![5_DispatcherServlet](https://user-images.githubusercontent.com/61631173/125952511-d8e9470e-db11-4316-a30b-77f4367ff8ef.JPG)

![6_Контроллер_описание](https://user-images.githubusercontent.com/61631173/125952513-cdddeafd-66ef-4555-bf8e-65f13fb522e0.JPG)

![7_Представление (View)_описание](https://user-images.githubusercontent.com/61631173/125952514-c3f33337-784e-4ed5-8c67-45097a38692c.JPG)

_ _ _ _

- **SpringMVCAppWebXML** - приложение с xml конфигурацией
_ _ _ _

- - **SpringMVCAppJavaConfig** - первое Spring MVC приложение</p>

![1_Контроллер](https://user-images.githubusercontent.com/61631173/126054470-d023abf2-e59b-4b61-9fe6-7280a8d3d97d.JPG)

![2_Контроллер and Component](https://user-images.githubusercontent.com/61631173/126054472-96520226-dcd3-4f39-bc9f-11371a59e82f.JPG)

![3_методы контроллера](https://user-images.githubusercontent.com/61631173/126054473-f338b24a-56d6-493a-9770-ed1aac081208.JPG)

![4_Маппинги](https://user-images.githubusercontent.com/61631173/126054474-e749b200-dbf5-4168-abbd-e5c7d30618ae.JPG)

![5_RequestMapping](https://user-images.githubusercontent.com/61631173/126054475-3777dfa4-cf8b-4d62-bafd-bfabcccdb8d2.JPG)

_ _ _ _

А теперь старые и добрые _**GET**_ _и _**POST**_, немного теории о них:

![1_HTTP Hyper Text Transfer Protocol](https://user-images.githubusercontent.com/61631173/126199408-f0f1a094-88da-4da5-b143-6f8b62085384.JPG)

![2_клиент-сервер](https://user-images.githubusercontent.com/61631173/126199421-5d1d451f-c66a-49af-82a8-f32150608f98.JPG)

![3_клиент-сервер](https://user-images.githubusercontent.com/61631173/126199423-99bf141f-9bbb-48d2-acf1-9679071c89ed.JPG)

![4_http на примере Google](https://user-images.githubusercontent.com/61631173/126199424-7db34611-4e06-412e-adb8-f25ecc3240d8.JPG)

![5_смотреть код страницы](https://user-images.githubusercontent.com/61631173/126199426-8a25725c-baca-4522-860a-c2afda895b25.JPG)

![6_просмотр данных страницы](https://user-images.githubusercontent.com/61631173/126199429-dd10e8e5-2138-4cc7-839e-2695c4de45e8.JPG)

![7_методы HTTP запроса](https://user-images.githubusercontent.com/61631173/126199430-98fbee34-9a88-4d42-8f58-96fcd088fd7e.JPG)

![8_GET-метод HTTP запроса](https://user-images.githubusercontent.com/61631173/126199432-79870a8e-6eee-4e37-a749-c0e069cbf1bd.JPG)

![9_GET-запрос параметры](https://user-images.githubusercontent.com/61631173/126199436-f3e9888f-6d99-4844-a744-949dddebbe13.JPG)

![10_POST-запрос](https://user-images.githubusercontent.com/61631173/126260024-7bef6209-db62-4817-bb74-5ff935d9bd9a.JPG)

![11_POST-запрос параметры](https://user-images.githubusercontent.com/61631173/126260025-682e9966-5717-4d37-a0f9-eb7e2c783c80.JPG)

![12_GET и POST-сравнение](https://user-images.githubusercontent.com/61631173/126260026-4d70e4fb-026b-4c34-a313-dc44a387e913.JPG)

![13_структура для передачи клиент - сервер](https://user-images.githubusercontent.com/61631173/126260028-371ab402-b90b-4643-a9d7-a587b53b8d4b.JPG)

![14_структура для передачи сервер - клиент](https://user-images.githubusercontent.com/61631173/126260030-1f0e0775-6115-4303-9393-2442d8d4b9c4.JPG)

![15_http response _структура для передачи сервер - клиент](https://user-images.githubusercontent.com/61631173/126260031-ae9dc836-4040-4ca3-bf4e-fe210a434438.JPG)

![16_http response _пример с Googla](https://user-images.githubusercontent.com/61631173/126260032-b26bab72-1cdd-4857-aca2-a83a39e1ad1e.JPG)

![17_http _ статусы ответов](https://user-images.githubusercontent.com/61631173/126260033-c2117f6c-691c-4906-b317-5fa88d7dfbd1.JPG)

![18_http _ типы содержимого](https://user-images.githubusercontent.com/61631173/126260035-0e75fd8c-b1d9-4f98-a272-1ed697c8ddad.JPG)

* * * * 

_**SpringRequestParameters**_ - рассмотрены GET запросы и как обрабатываются параметры которые передаются в URL запросе в самом адресе на серевер с помощью Spring Framework</p>

![1_запросы к серверу](https://user-images.githubusercontent.com/61631173/126585096-aa3cc32a-6849-4eb0-9d46-fdbacfb4b076.JPG)

![2_клиент-сервер](https://user-images.githubusercontent.com/61631173/126585097-053a3af1-9043-4639-9291-ed1cf12539a9.JPG)

![3_параметры GET запроса](https://user-images.githubusercontent.com/61631173/126585099-8f2ccf5c-bcb0-435b-9ec6-f621a32ce4a1.JPG)

![4_способы получения GET запросов](https://user-images.githubusercontent.com/61631173/126585100-48189d93-4ce7-4727-9e8b-5c8938e04048.JPG)

![5_пример_добавление параметров в Get запрос через_HttpServletRequest](https://user-images.githubusercontent.com/61631173/126585101-bc09b8f6-9a43-4c85-9726-784d71c0adcc.JPG)

![6_пример_внесение в браузере параметров Get запроса через_HttpServletRequest](https://user-images.githubusercontent.com/61631173/126585102-d1387879-8e56-46e8-86f4-a3e71f1638fc.JPG)

![7_пример_вывод  в консоли параметров Get запроса через_HttpServletRequest](https://user-images.githubusercontent.com/61631173/126585103-bd649b9a-beb0-4b5f-9cd4-cb9e28d24df9.JPG)

![8_пример_добавление параметров в Get запрос через_аннотацию RequestParameter](https://user-images.githubusercontent.com/61631173/126587912-24d74b33-1806-45ef-baa1-f1bad25d7c20.JPG)

![9_пример_внесение в браузере параметров Get запроса через_@RequestParameter](https://user-images.githubusercontent.com/61631173/126587915-7bf6ed55-46ce-4d9f-9369-8a93eae9c628.JPG)

вывод в консоли параметров Get запроса, введённых через_@RequestParameter в строке браузера:
![10_пример_вывод  в консоли параметров Get запроса через_@RequestParameter](https://user-images.githubusercontent.com/61631173/126587917-2df338a4-fcf1-4f01-a1ed-d7132325d320.JPG)

Вывод ошибки 400, если ввести запрос через @RequestParameter без параметров...
![11_пример_вывод ошибки без параметров Get запроса через_@RequestParameter](https://user-images.githubusercontent.com/61631173/126608142-141548a2-1a70-45b6-9fd3-2158f8d3c50b.JPG)

Таким образом, видно, что Get запрос ждёт введение параметров, указанных в методе, иначе каждый раз будет вывод ошибки 400.</p>
Для устранения данной ошибки, необходимо в параметрах метода @RequestParam укзать "required = false", что позволит избежать ошибки.

![12_пример_код устранения вывода ошибки без параметров Get запроса через_@RequestParameter](https://user-images.githubusercontent.com/61631173/126610393-fb57085b-06b9-42a3-8480-da4e9f99caca.JPG)

Здесь можно пронаблюдать как выводятся данные страницы...

![13_пример_вывод в консоли без параметров_@RequestParameter](https://user-images.githubusercontent.com/61631173/126610551-0b29ceff-4854-4c13-8db6-6511235ada70.JPG)

Вывод в консоли значений null null...

![14_пример_вывод в консоли без параметров null null_@RequestParameter](https://user-images.githubusercontent.com/61631173/126610948-c2b852f7-8d5d-4407-9112-1b07807a28ca.JPG)

пример передачи параметров Get запросов при нажатии на ссылку на странице браузера: 
необходимо в html странице, прописать обращение к методу контроллера с параметрами Get запроса... 
![15_пример_передачи параметров Get запросов при нажатии на ссылку _@RequestParameter](https://user-images.githubusercontent.com/61631173/126612258-1de1bc6d-a9ff-47cd-b2b7-95f413659f95.JPG)</p>
Вывод на странице браузера ссылки на страницу с параметрами...
![16_пример_вывод на странице ссылки с параметрами_@RequestParameter](https://user-images.githubusercontent.com/61631173/126612585-907ab2a7-506d-4f95-bb00-24365a241be5.JPG)

_ _ _ _

_**SpringIntroToModel**_ - передача данных от контроллера к модели</p>
![1_модель данных от контроллера к представлению](https://user-images.githubusercontent.com/61631173/126619723-9128064d-4f77-4f68-a109-4616cc632842.JPG)</p>
![2_MVC - паттерн проектирования приложений (Model View Controller)](https://user-images.githubusercontent.com/61631173/126619726-218f189e-6d20-4b25-a8ab-44617ba1b6bd.JPG)</p>
![3_Модель -контейнер для данных нашего приложения](https://user-images.githubusercontent.com/61631173/126619728-c83dda75-9383-4d34-98c4-812bc847393b.JPG)</p>
![4_часть Модели рассмотренная в этом приложении](https://user-images.githubusercontent.com/61631173/126619729-c297e99b-59d9-47ae-b020-8f203badc1b8.JPG)</p>
![5_получение доступа к модели в контроллере](https://user-images.githubusercontent.com/61631173/126619730-5c159d94-e3b8-4c95-a99b-52266c4e68ca.JPG)</p>

В нашем ранее рассмотреном примере продемонстрируем работу передачи данных...</p>
Ддобавление модели в контроллере:
![6_добавление модели в контроллере](https://user-images.githubusercontent.com/61631173/126620104-23c951bb-2365-4988-8612-be879930f6dc.JPG)</p>
обращение в представлении к контроллеру по ключу модели....
![7_пример_обращение в представлении к контроллеру по ключу модели](https://user-images.githubusercontent.com/61631173/126620105-d73b5a26-9f3a-4de4-9eb3-d621c312ad35.JPG)</p>
Вывод данных на странице браузера:
![8_пример_вывод на странице браузера](https://user-images.githubusercontent.com/61631173/126620101-d3b67b49-c726-4980-a1ba-62e3004cdd59.JPG)</p>
- **_Самостоятельно задание_** - _SpringSinpleCalculator_
![9_**самостоятельно задание**_](https://user-images.githubusercontent.com/61631173/126621032-5c90f896-1e9a-4bfd-afe1-e8ba0868cf32.JPG)</p>
_Решение_</p>
написание метода в контроллере для вычисления чисел:
![10_самостоятельно задание_написание метода контроллера для выполнения вычисления](https://user-images.githubusercontent.com/61631173/126635320-6d8326a2-11e4-42c1-a67a-d53ee83a2815.JPG)</p>
написание представления для обращения к модели контроллера
![11_самостоятельно задание_написание представления (html)  для обращения к контроллеру](https://user-images.githubusercontent.com/61631173/126635325-4f2697fb-0ef8-437d-b4ba-dbf727bbb8cc.JPG)</p>
задание параметров и вывод результатов:
![12_самостоятельно задание_задание параметров и результат вывода в браузере](https://user-images.githubusercontent.com/61631173/126635327-ca8d10ba-c2d9-4515-b347-ebf1e674f6bf.JPG)</p>

_ _ _ _ 

- _**Spring_CRUD_App**_ - в данном приложении рассматривается начало реализации CRUD приложения для сущности Person</p>
Немного теории и переход к написанию приложения.</p>

![1_CRUD](https://user-images.githubusercontent.com/61631173/126773471-0814fe28-a2e6-4219-9c5b-5ca36aba05bd.JPG)

![2_CRUD - определение](https://user-images.githubusercontent.com/61631173/126773473-a6238caa-1bef-456d-895e-a71cfdf5be40.JPG)

![3_HTTP -CRUD](https://user-images.githubusercontent.com/61631173/126773475-08af0ab7-1e6b-4f8d-bb6b-83fae84f94c8.JPG)

![4_стандарт CRUD's](https://user-images.githubusercontent.com/61631173/126773476-006ddd73-f2ee-4700-8bb7-7871a02fd168.JPG)

![5_почему именно такие методы_](https://user-images.githubusercontent.com/61631173/126773477-44ae09f7-fa06-4a09-967e-611e2160312e.JPG)

![6_REST   CRUD_](https://user-images.githubusercontent.com/61631173/126773479-dc9ce719-b5f5-4019-8176-225ff762ff4b.JPG)

![7_описание урока](https://user-images.githubusercontent.com/61631173/126773462-d784c966-adb3-4efe-8226-39a627cd61dc.JPG)

![8_связь с БД](https://user-images.githubusercontent.com/61631173/126773464-865b1d03-2ad3-4917-85af-e288379b0956.JPG)

![9_описание приложения, работающего с БД](https://user-images.githubusercontent.com/61631173/126773467-4a043f3c-2a6c-4de5-bc0e-5ac26b67f0b5.JPG)

![10_описание приложения, работающего с БД (временно ArrayList)](https://user-images.githubusercontent.com/61631173/126773468-9e900220-b141-4339-ada5-0d5a04fe0ece.JPG)</p>
После теории переход к написанию приложения, сделал скриншоты с работающего примера приложения, пока без подключения базы данных.</p>
Класс контроллер PeopleController:
![11_приложение_класс-контроллер PeopleController](https://user-images.githubusercontent.com/61631173/126775064-6b7aa7c8-04e2-4908-8c3a-3da3505b5888.JPG)
Класс сущности Person:
![12_приложение_класс сущности Person](https://user-images.githubusercontent.com/61631173/126774374-e113c6b0-a36b-4969-896e-c5d9d12c3a66.JPG)
 Класс, работающий с БД - PersonDAO:
![13_приложение_класс для работы с БД](https://user-images.githubusercontent.com/61631173/126774375-bc8d6a75-03ec-47a0-91b5-080b62beca53.JPG)
Представление в виде html страницы, на которой выводится список людей:
![14_приложение_html страница представления_index](https://user-images.githubusercontent.com/61631173/126774377-37fe0d1a-fc56-4d38-91aa-4226a44ea082.JPG)
Представление в виде html страницы, на которой выводится имя и id человека:
![15_приложение_html страница представления_show](https://user-images.githubusercontent.com/61631173/126774379-6bc0aa75-2eb8-4d6d-a5d3-113ccd332a82.JPG)
страница браузера_вывод списка людей:
![16_приложение_страница браузера_вывод списка людей_index](https://user-images.githubusercontent.com/61631173/126774367-0fcfd752-c5d2-4b5c-b88c-2f0596a7db6e.JPG)
страница браузера_вывод человека по id:
![17_приложение_страница браузера_вывод человека по id_show](https://user-images.githubusercontent.com/61631173/126774370-d4312bb6-4693-4452-95cd-775cecc8e362.JPG)
_ _ _ _
- _**Spring_CRUD_App2**_ - в данном приложении рассмотрена аннотация @ModelAttribute и HTML Формы (Thymeleaf).</p>
![1_@ModelAttribute](https://user-images.githubusercontent.com/61631173/126778300-6885e46a-12c4-497d-a204-b3e9a6015729.JPG)
![2_реализация прошлого урока](https://user-images.githubusercontent.com/61631173/126778307-8af25e3e-e0d6-48ab-a566-384314361ec0.JPG)
![3_реализация этого урока](https://user-images.githubusercontent.com/61631173/126778308-31de7d48-8b4f-4acd-be7f-b9db256c0a93.JPG)
![4_HTML формы](https://user-images.githubusercontent.com/61631173/126778310-5b4aabfa-dcd7-451a-a33c-c194f0fa9811.JPG)
![5_HTML формы в Thymeleaf](https://user-images.githubusercontent.com/61631173/126778311-1d3c5c5a-c3a4-49c2-8ecc-9cca79a53e41.JPG)
![6_на контроллере](https://user-images.githubusercontent.com/61631173/126778312-1c3cae85-7d02-47bb-b70d-227d66613e31.JPG)
![7_@ModelAttribute](https://user-images.githubusercontent.com/61631173/126778313-e12f51ef-0b0d-4fe3-bc83-300f8c2006db.JPG)
![8_@ModelAttribute_когда аннотируют](https://user-images.githubusercontent.com/61631173/126778315-83cd5502-7449-4927-9183-15b642c0b7fc.JPG)
![9_@ModelAttribute_когда аннотируют2](https://user-images.githubusercontent.com/61631173/126778318-048d1d57-1708-444b-993b-b6e292123fde.JPG)
![10_@ModelAttribute_когда аннотируют аргумент метода](https://user-images.githubusercontent.com/61631173/126778319-e34fe723-6997-49ed-8a08-c34ab2f9532d.JPG)
![11_@ModelAttribute_когда аннотируют аргумент метода2](https://user-images.githubusercontent.com/61631173/126778321-aee3acfe-104c-41ca-b8af-369db4e9163c.JPG)</p>
_ПРАКТИКА_</p>
_добавление в контроллер методов с @GetMapping и @PostMapping:_</p>
![12_пример_добавление в контроллер методов с @GetMapping и @PostMapping](https://user-images.githubusercontent.com/61631173/126782675-4d065389-2d06-47f6-a74b-1c5e73e5025b.JPG)</p>
_Создание конструктора класса Person, для добавление человека:_</p>
![13_пример_создание конструктора класса Person](https://user-images.githubusercontent.com/61631173/126783209-7ee2be24-c87f-4c5e-aa17-55a8676ce5cf.JPG)</p>
_добавление метода creat() в классе PersonDAO работы с БД:_</p>
![14_пример_добавление метода creat() в классе работы с БД](https://user-images.githubusercontent.com/61631173/126783215-820528c0-450f-4708-a84d-24a4d52c420f.JPG)</p>
_создание новой html страницы для добавления человека в БД:_</p>
![15_пример_создание новой html страницы для добавления человека в БД](https://user-images.githubusercontent.com/61631173/126783217-ec4fd098-7c09-4675-9180-07779bd95f3a.JPG)</p>
_Проверка в браузере страницы добавления человека:_</p>
![17_пример_проверка в браузере страницы для добавления человека в БД](https://user-images.githubusercontent.com/61631173/126783220-76655962-49e8-4daf-bd44-391e244a7170.JPG)</p>
_Добавление человека в БД с выодом на странице браузера:_</p>
![16_пример_добавление человека в БД](https://user-images.githubusercontent.com/61631173/126783218-27249197-ff4c-451b-8fef-d7f3503da435.JPG)</p>
_Страница информации имени человека и его id:_</p>
![18_пример_страница информации человека в БД](https://user-images.githubusercontent.com/61631173/126783900-0a0e999d-967a-4eda-b513-290df1b7de6f.JPG)</p>
_Применение аннотации @@ModelAttribute вместо вызова класса Model в параметре:_</p>
![19_пример_применение аннотации @@ModelAttribute вместо вызова класса Model в параметре](https://user-images.githubusercontent.com/61631173/126783903-7666e1e3-000d-47f5-ad88-2ce649ef6b9c.JPG)</p>
_ _ _ _

- **_Spring_CRUD_App3_** - приложение доработано, теперь оно сможет обновлять и удалять данные</p>

![1_CRUD_методы Update_Delete](https://user-images.githubusercontent.com/61631173/126788200-334d9563-f508-4776-aa81-f7f85925ef81.JPG)</p>
![2_CRUD_методы Update_Delete на этом уроке](https://user-images.githubusercontent.com/61631173/126788202-8ce0c25c-d75c-424f-ae9e-dd84ffb2e9a3.JPG)</p>
План урока...</p>
![3_CRUD_план урока](https://user-images.githubusercontent.com/61631173/126788205-a6bd8334-2f86-42bd-8bc6-50677078ed71.JPG)</p>
Немного теории...</p>
![4_деталь реализации PATCH_ DELETE и др  запросов](https://user-images.githubusercontent.com/61631173/126788207-84ad1d81-c486-48ea-bbf9-96211cae4229.JPG)</p>
![5_решение проблемы](https://user-images.githubusercontent.com/61631173/126788209-6985ac03-b69b-46d1-baf6-37524154aebc.JPG)</p>
![6_решение проблемы с поомщью фильтра](https://user-images.githubusercontent.com/61631173/126788211-79b70238-b610-4856-81ba-6a838cf69413.JPG)</p>

_ПРАКТИКА_</p>
_В примере прошлого приложения добавляем методы  edit и update в контроллере:_</p>
![7_пример_добавление методов edit и update в контроллере](https://user-images.githubusercontent.com/61631173/126794486-3eb31b52-1e21-4847-90fb-5b35676d23a2.JPG)</p>
..._в классе PersonDAO добавляем метод update_ </p>
![8_пример_добавление метода update в классе PersonDAO](https://user-images.githubusercontent.com/61631173/126794494-43072435-a9e3-402c-9364-e9b24bf9870a.JPG)</p>
_... создали страницу html  для редактирования данных человека_</p>
![9_пример_создание страницы html для редактирования данных человека](https://user-images.githubusercontent.com/61631173/126794498-25398da6-ef2d-4e40-bb67-050f7c7f55d5.JPG)</p>
_Ошибка 405 при изменении имени человека_
![10_пример_страница ошибки 405](https://user-images.githubusercontent.com/61631173/126798157-1f578fa4-a74c-4363-82d6-6ece1961cbb2.JPG)</p>

_... добавление методов позволяющих вносить изменения для Spring и избежания ошибки 405_</p>
![10_пример_добавление методов позволяющих вносить изменения для Spring и избежания ошибки 405](https://user-images.githubusercontent.com/61631173/126794501-d75d2e44-60ff-43b0-b516-e97edfe4e268.JPG)</p>
_проверяем на странице изменения данных выполнение прописанных методов_
![11_пример_страница изменения имени человека](https://user-images.githubusercontent.com/61631173/126794503-c6d2e9f5-f61a-4292-889e-a1c5c9188074.JPG)</p>
_... страница списка людей с изменённым именем_
![12_пример_страница списка людей с изменённым именем](https://user-images.githubusercontent.com/61631173/126794505-0c06b87d-dca9-47c4-b018-2520a8c489cf.JPG)</p>

_Добавление метода для удаления персоны:_</p>
_метод delete в контроллере_</p>
![13_пример_добавление метода delete в контроллере](https://user-images.githubusercontent.com/61631173/126823429-405deabd-8530-4ea3-9587-289cad7c5adc.JPG)</p>
_метод delete в классе PersonDAO_</p>
![14_пример_добавление метода delete в классе PersonDAO](https://user-images.githubusercontent.com/61631173/126824569-17acd9fa-85de-4f31-a963-0ed100004438.JPG)

_форма delete в странице html Show_</p>
![15_пример_добавление формы delete в странице html Show](https://user-images.githubusercontent.com/61631173/126823431-92bfe486-ea2e-40bd-8002-c6448b531632.JPG)</p>
![16_пример_добавление ccылки на создание персоны](https://user-images.githubusercontent.com/61631173/126823432-7137c953-5a9f-4e17-8370-1d0f314e808a.JPG)</p>
![17_пример_страница браузера списка людей](https://user-images.githubusercontent.com/61631173/126823434-85c94b37-f912-4ddf-a122-385c98008150.JPG)</p>
![18_пример_страница браузера для просмотра, редактирования и удаления персоны](https://user-images.githubusercontent.com/61631173/126823437-0f89d85a-581c-4b85-ba53-b06a6ceaee46.JPG)</p>
![19_пример_страница браузера списка людей после удаления из списка персоны Sanya](https://user-images.githubusercontent.com/61631173/126823439-374c3f26-dc2b-48b4-923a-da220b18a4af.JPG)</p>
_ _ _ _ 

- **_Spring_FormsValidation_** - данный проект, продолжение предыдущего, в начале которого добавлено пару параметров: возвраст и эл.почта</p>
<!-- В начале проект добавляется зависимость: </p> -->
**цель урока**: научиться правильно офрмлять поля для их адекватного заполнения (например: в поле Email не должны вводиться данные эл. почты без @).</p>
Всего этого можно добиться при помощи специальных аннотаций, которые подгружаются после добавления зависимости hibernate-validator в файл pom.xml
![1_пример_Зависимость версии 7 0 1 Final не срабатывала на вывод ошибок!](https://user-images.githubusercontent.com/61631173/126855826-c3a236b8-e5c5-4689-9905-b63d6006b06e.JPG)</p>
...Зависимость hibernate-validator версии 7 0 1 Final не срабатывала на вывод ошибок, сработала зависимость hibernate-validator версии 6.1.6.Final представленая на уроке 24 данного курса</p>
После добавления зависимости, добавляются необходимые аннотации в класс Person:</p>
![2_пример_класс Person_добавление необходимых аннотаций](https://user-images.githubusercontent.com/61631173/126856036-46d33114-4b22-4a6a-93af-48bf6f33dfab.JPG)</p>
... далее в методах _update_ и _create_ класса контроллера вносятся аннотации @Valid перед входящими праметрами Person и прописывается необходимое условие:</p>
![3_пример_@Valid перед входящим параметром Person методов create и update](https://user-images.githubusercontent.com/61631173/126856242-f689184d-3dd3-46f8-8be0-262faa746a5b.JPG)</p>
... на страницах html _edit_ и _new_ добавлены теги для вывода сообщений красным цветом об ошибках при введении не подходящей информации в соответствующие поля </p>
![4_пример_добавление тегов с условием о возникновении ошибок на странице update](https://user-images.githubusercontent.com/61631173/126856524-28c448d8-8ef1-47b1-be82-e67ce111c52d.JPG)</p>
![5_пример_добавление тегов с условием о возникновении ошибок](https://user-images.githubusercontent.com/61631173/126856525-1668c506-0442-428e-9e10-342141e243b8.JPG)</p>
... после всего проделанного можно запустить приложение и убедиться в выводе информации об ошибках при не правильно введённой информации:</p>
![6_пример_демо_вывод ошибки на странице при неправилном вводе](https://user-images.githubusercontent.com/61631173/126856666-eaf6dbd8-df9d-461c-aa03-3d1194c42ddb.JPG)
</p>
_ _ _ _
![1_заголовок урока_БД](https://user-images.githubusercontent.com/61631173/126857288-df726044-a630-41ae-8cd0-a25d06736c5d.JPG)
![2_проблема хранения данных в оперативной памяти](https://user-images.githubusercontent.com/61631173/126857291-859aee00-572d-4b14-bee2-398880ea18a9.JPG)
![3_описание реляционных БД](https://user-images.githubusercontent.com/61631173/126857292-cd7723bc-7cc3-4688-a25f-55948a221538.JPG)
![4_БД PostreSQL](https://user-images.githubusercontent.com/61631173/126857293-36b0dfe0-ac7d-4491-bf74-d4ca6f443c69.JPG)
![5_связь Java приложения с БД](https://user-images.githubusercontent.com/61631173/126857294-d0bfaf6a-6e7a-40c0-b374-d65847e251ab.JPG)
![6_связь Java приложения с БД_описание](https://user-images.githubusercontent.com/61631173/126857295-9afaaf1a-2171-4b10-9040-6a8f1aaefcde.JPG)
![7_как подклюиться к БД](https://user-images.githubusercontent.com/61631173/126857296-89bec5f9-b512-4c44-8c0d-518104e0a0fd.JPG)
![8_БД основные команды](https://user-images.githubusercontent.com/61631173/126857297-d21fec36-9f85-4aa2-9106-41be9bef9083.JPG)
![9_цель этого урока_подключение БД вместо используемого списка](https://user-images.githubusercontent.com/61631173/126857298-5b5fc5fb-558a-4d6a-9feb-aef0480cec0e.JPG)
