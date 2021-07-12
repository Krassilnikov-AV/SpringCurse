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
B примере рассматривается жизненный цикл бина, при помощи создания методов public static ClassicalMusic getClassicalMusic(), возвращающим экземпляр ClassicalMusic, метода public  void doMyInit() и public  void doMyDestroy() и прописанием методов в applicationContext.xml</p> В консоли выведится порядок вызываемых методов, что и покажет жизненный цикл Бина.</p>
Основные особенности  **_init_** и **_destroy_** методов</p>
1. **Модификатор доступа** - у данных методов может быть любой модификатор (_public, protected, private_)
2. **Тип возвращаемого значения** - может быть любой, но чаще всего используется _void_ (т.к. нет возможности получить возвращаемое значение).
3. **Название метода** - название модет быть любым
4. **Аргументы метода** - эти методы **не должны** принимать на вход какие - либо аргументы</p>
Одна важная особенность бинов со scope - **_"prototype"_** Spring **не вызывает destroy метод.**</p>
- Spring не берет на себя полный жизненный цикл бинов со scope _"prototype"_. Spring отдаёт _prototype_ бины клиенту и больше о них не заботится (в отличии от singleton бинов).</p>
ЗАДАНИЕ: </p>
- убедиться что  Spring не вызывает destroy метод.
- убедиться сколько раз вызывается init-method, если мы получаем несколько prototype бинов.
