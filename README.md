# Dagger2example

The project shows an example how to use Dagger2 in unit tests. Basically there is a window in ```org.robospock.dagger2unittests.inject.Injector.java```
```java
public static void override(ToasterModule toasterModule)
```

which allows to ship a class overriding original ToasterModule methods.

In Robolectric test it looks like this
``` java
final Toaster mock = Mockito.mock(Toaster.class);
Injector.override(new ToasterModule(Robolectric.application) {
  @Override
  public Toaster provideToaster(Context context) {
    return mock;
  }
});
```

Now you can make any interaction using Mockito framework.

In future I will add working RoboSpock version.

# Build & Run

The project uses following Gralde plugins:
* Android plugin 1.1.0 - for unit test support
* Robolectric plugin 1.0.1 - for running Robolectric from command lint
* APT plugin 1.4 - for marking generated classes as source in Android Studio
* Andorid-SDK-Manager 0.12 plugin - for automatic Android SDK download

Run tests from command line
```
./gradlew test
```

You can run tests also in Android Studio but you need to change defualt jUnit Working Directory to
```
{projectPath}/app/src/main
```
