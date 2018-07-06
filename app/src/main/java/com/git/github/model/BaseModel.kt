/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 8:57 AM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 8:57 AM
 *
 */

package com.git.github.model

import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder
import org.apache.commons.lang3.builder.ToStringBuilder

abstract class BaseModel {
    override fun toString(): String {
        return ToStringBuilder.reflectionToString(this)
    }

    override fun hashCode(): Int {
        return HashCodeBuilder.reflectionHashCode(this)
    }

    override fun equals(other: Any?): Boolean {
        return EqualsBuilder.reflectionEquals(this, other)
    }
}