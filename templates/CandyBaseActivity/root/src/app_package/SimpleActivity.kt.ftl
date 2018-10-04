package ${escapeKotlinIdentifiers(packageName)}

import android.os.Bundle
<#if applicationPackage??>
import ${applicationPackage}.R
</#if>
import com.td.framework.base.activity.CandyBaseActivity
/**
 * Created on ${.now}
 * @author: aohanyao
 * @version:1.0
 */
class ${activityClass} : CandyBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.${layoutName})
    }

}
