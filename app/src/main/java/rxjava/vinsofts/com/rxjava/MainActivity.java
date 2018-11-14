package rxjava.vinsofts.com.rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import rxjava.vinsofts.com.rxjava.Adapter.Myadapter;
import rxjava.vinsofts.com.rxjava.model.Collection;
import rxjava.vinsofts.com.rxjava.model.Example;
import rxjava.vinsofts.com.rxjava.remote.ISOService;
import rxjava.vinsofts.com.rxjava.remote.RetrofitClient;

public class MainActivity extends AppCompatActivity {
    private ISOService isoService;
    private List<Collection> list1;
    private List<Collection> list2;
    private List<Collection> list3;
    private List<Collection> list4;
    private Myadapter myadapter1;
    private Myadapter myadapter2;
    private Myadapter myadapter3;
    private Myadapter myadapter4;

    @BindView(R.id.rc_Main1)
    RecyclerView rcMain1;
    @BindView(R.id.rc_Main2)
    RecyclerView rcMain2;
    @BindView(R.id.rc_Main3)
    RecyclerView rcMain3;
    @BindView(R.id.rc_Main4)
    RecyclerView rcMain4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        isoService = RetrofitClient.getSOService();

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();

        myadapter1 = new Myadapter(this, list1);
        myadapter2 = new Myadapter(this, list2);
        myadapter3 = new Myadapter(this, list3);
        myadapter4 = new Myadapter(this, list4);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        rcMain1.setLayoutManager(layoutManager1);
        rcMain2.setLayoutManager(layoutManager2);
        rcMain3.setLayoutManager(layoutManager3);
        rcMain4.setLayoutManager(layoutManager4);

        rcMain1.setAdapter(myadapter1);
        rcMain2.setAdapter(myadapter2);
        rcMain3.setAdapter(myadapter3);
        rcMain4.setAdapter(myadapter4);
        getdata1();
        getdata2();
        getdata3();
        getdata4();
    }

    @SuppressLint("CheckResult")
    private void getdata1() {
        isoService.getdata1()
                .map(Example::getCollection)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        collections -> {
                            list1.addAll(collections);
                            myadapter1.notifyDataSetChanged();
                        });
    }

    @SuppressLint("CheckResult")
    private void getdata2() {
        isoService.getdata2()
                .map(Example::getCollection)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        collections -> {
                            list2.addAll(collections);
                            myadapter2.notifyDataSetChanged();
                        });
    }

    @SuppressLint("CheckResult")
    private void getdata3() {
        isoService.getdata3()
                .map(Example::getCollection)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        collections -> {
                            list3.addAll(collections);
                            myadapter3.notifyDataSetChanged();
                        });
    }

    private void getdata4() {
        isoService.getdata4()
                .map(new Function<Example, List<Collection>>() {
                    @Override
                    public List<Collection> apply(Example example) throws Exception {
                        return example.getCollection();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Collection>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Collection> o) {
                        list4.addAll(o);
                        myadapter4.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
