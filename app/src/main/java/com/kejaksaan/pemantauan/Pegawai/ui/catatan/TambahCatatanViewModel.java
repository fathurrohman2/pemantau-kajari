package com.kejaksaan.pemantauan.Pegawai.ui.catatan;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.google.android.gms.common.api.Api;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.tdn.data.service.ApiService;
import com.tdn.domain.model.CatatanModel;
import com.tdn.domain.serialize.req.RequestPostAddCatatan;
import com.tdn.domain.serialize.res.ResponseAction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class TambahCatatanViewModel extends ViewModel {
    private ApiService apiService;
    private Context context;
    private ActionListener actionListener;

    public TambahCatatanViewModel(Context context, ActionListener actionListener) {
        this.actionListener = actionListener;
        this.context = context;
        this.apiService = ApiService.Factory.create();
    }

    // TODO: Implement the ViewModel
    public void simpan(RequestPostAddCatatan req) {
        actionListener.onStart();
        apiService.postCatatan(req)
                .enqueue(new Callback<ResponseAction>() {
                    @Override
                    public void onResponse(Call<ResponseAction> call, Response<ResponseAction> response) {
                        if (cek(response.code())) {
                            if (cek(response.body().getResponseCode())) {
                                actionListener.onSuccess(response.body().getResponseMessage());
                            } else {
                                actionListener.onError(response.body().getResponseMessage());
                            }
                        } else {
                            actionListener.onError(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseAction> call, Throwable t) {
                        actionListener.onError(t.getMessage());
                    }
                });
    }
}