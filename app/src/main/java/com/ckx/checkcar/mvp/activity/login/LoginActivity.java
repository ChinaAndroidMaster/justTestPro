package com.ckx.checkcar.mvp.activity.login;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ckx.checkcar.R;
import com.ckx.checkcar.base.UIManager;
import com.ckx.checkcar.base.edutils.EncryptDecrypt;
import com.ckx.checkcar.base.ui.activity.ToolbarActivity;
import com.ckx.checkcar.base.utils.MobileVerifier;
import com.ckx.checkcar.base.utils.WidgetUtil;
import com.ckx.checkcar.commons.ProgressGenerator;
import com.ckx.checkcar.mvp.activity.main.MainActivity;
import com.ckx.checkcar.mvp.presenter.LoginPresenter;
import com.ckx.checkcar.mvp.view.LoginView;
import com.ckx.checkcar.wigdet.ClearEditText;
import com.dd.processbutton.iml.ActionProcessButton;
import com.github.yoojia.inputs.AndroidNextInputs;
import com.github.yoojia.inputs.Scheme;
import com.github.yoojia.inputs.StaticScheme;
import com.github.yoojia.inputs.ValueScheme;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends ToolbarActivity<LoginView, LoginPresenter> implements LoginView, ProgressGenerator.OnCompleteListener
{
    private final AndroidNextInputs mInputs = new AndroidNextInputs();
    final ProgressGenerator progressGenerator = new ProgressGenerator(this);

    @BindView(R.id.btnSignIn)
    ActionProcessButton mActionProcessButton;

    @BindView(R.id.et_user_name)
    ClearEditText mEtUserName;

    @BindView(R.id.et_passwd)
    ClearEditText mEtPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter()
    {
        return new LoginPresenter();
    }

    @Override
    public int layoutResID()
    {
        return R.layout.activity_login;
    }

    @Override
    public void initViews()
    {
        mEtUserName.setText("18518378315");
        mEtPasswd.setText("123456");

        //设置校验规则
        mInputs.add(mEtUserName, StaticScheme.Required(), new Scheme(new MobileVerifier()).msg("请输入有效的手机号"));
        mInputs.add(mEtPasswd, StaticScheme.Required(), StaticScheme.NotBlank(), ValueScheme.MaxLength(6));
    }

    @Override
    public void initEvents()
    {
    }

    @Override
    public String getToolbarTitle()
    {
        return this.getString(R.string.login_title);
    }

    @Override
    public void onComplete()
    {

    }

    @Override
    public void result(boolean aSucess, String aMsg)
    {
        if (aSucess)
        {
            this.finish();
            UIManager.startActivity(this, MainActivity.class);
        } else
        {
            //TOAST.SHOW(MSG)
        }
    }

    @Override
    public String getPhoneNum()
    {
        return WidgetUtil.getEditTextContent(mEtUserName);
    }

    @Override
    public String getPasswd()
    {
        String tPasswd = WidgetUtil.getEditTextContent(mEtPasswd);

        Logger.d("orgin passwd = %s", tPasswd);

        String tDPasswd = EncryptDecrypt.getInstance().encrypt(tPasswd);

        Logger.d("encryp passwd = %s", tDPasswd);

        return tDPasswd;
    }

    @Override
    public void showActionProgress()
    {
    }

    @Override
    public void hideActionProgress()
    {
    }

    @Override
    public void onStart()
    {
        super.onStart();
    }

    @Override
    public void onStop()
    {
        super.onStop();
    }

    @OnClick(R.id.btnSignIn)
    public void login()
    {
        if (mInputs.test())
        {
            progressGenerator.start(mActionProcessButton);
            mActionProcessButton.setEnabled(false);
            mEtUserName.setEnabled(false);
            mEtPasswd.setEnabled(false);
            getPresenter().login();
        }
    }
}
