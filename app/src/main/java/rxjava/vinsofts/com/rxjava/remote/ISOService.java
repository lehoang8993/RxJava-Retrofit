package rxjava.vinsofts.com.rxjava.remote;

import io.reactivex.Observable;
import retrofit2.http.GET;
import rxjava.vinsofts.com.rxjava.model.Example;

public interface ISOService {
    @GET("charts?kind=top&genre=soundcloud%3Agenres%3Aall-music" +
            "&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=100&offset=0")
    Observable<Example> getdata1();

    @GET("charts?kind=top&genre=soundcloud%3Agenres%3Aall-audio" +
            "&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=100&offset=0")
    Observable<Example> getdata2();

    @GET("charts?kind=top&genre=soundcloud%3Agenres%3Aalternativerock" +
            "&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=100&offset=0")
    Observable<Example> getdata3();

    @GET("charts?kind=top&genre=soundcloud%3Agenres%3Aambient" +
            "&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=100&offset=0")
    Observable<Example> getdata4();

}
