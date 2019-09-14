package br.com.como_voce_mora.ui.aboutyou;

import androidx.fragment.app.Fragment;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseActivity;
import br.com.como_voce_mora.ui.atualresidence.CurrentHomeFragment;

public class AboutYouActivity extends BaseActivity {

    @Override
    public int getResLayout() {
        return R.layout.activity_about_you;
    }

    @Override
    public void init() {
        super.init();
        replaceFragment(HowOldAreYouFragment.newInstance());
    }


    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(fragment.getClass().getSimpleName())
                .add(R.id.container, fragment)
                .commitAllowingStateLoss();
    }
}
