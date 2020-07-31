/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drake.brv.sample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.drake.brv.listener.OnHoverAttachListener
import com.drake.brv.sample.R
import com.drake.brv.sample.model.HoverHeaderModel
import com.drake.brv.sample.model.Model
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.drake.tooltip.toast
import kotlinx.android.synthetic.main.fragment_hover_header.*


class HoverHeaderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hover_header, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_hover.linear().setup {
            addType<Model>(R.layout.item_multi_type_simple)
            addType<HoverHeaderModel>(R.layout.item_hover_header)
            models = getData()

            // 点击事件
            onClick(R.id.item) {
                when (itemViewType) {
                    R.layout.item_hover_header -> toast("悬停条目")
                    else -> toast("普通条目")
                }
            }

            // 可选项, 粘性监听器
            onHoverAttachListener = object : OnHoverAttachListener {
                override fun attachHover(v: View) {
                    ViewCompat.setElevation(v, 10F)
                }

                override fun detachHover(v: View) {
                    ViewCompat.setElevation(v, 0F)
                }
            }

        }
    }

    private fun getData(): List<Any> {
        return listOf(
            HoverHeaderModel(),
            Model(),
            Model(),
            Model(),
            HoverHeaderModel(),
            Model(),
            Model(),
            Model(),
            HoverHeaderModel(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model()
        )
    }

}
