package ${packageName};

import android.os.Bundle;
import android.view.View;
import com.td.framework.base.activity.CandyBaseActivity;
<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>
/**
 * Created on ${.now}
 * @author: aohanyao
 * @version:1.0
 */
public class ${activityClass} extends CandyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.${layoutName});
    }

}
