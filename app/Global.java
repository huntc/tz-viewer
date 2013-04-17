import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import play.GlobalSettings;
import services.TZService;
import services.ZoneInfoTZService;

/**
 * Application wide behaviour.
 */
public class Global extends GlobalSettings {

    private Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            bind(TZService.class).to(ZoneInfoTZService.class);
        }
    });

    @Override
    public <A> A getControllerInstance(Class<A> aClass) {
        return injector.getInstance(aClass);
    }
}
