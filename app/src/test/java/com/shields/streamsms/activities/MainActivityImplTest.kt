package com.shields.streamsms.activities

import com.shields.streamsms.R
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

class MainActivityImplTest {

    @Mock private lateinit var mainActivity: MainActivity

    private lateinit var subject: MainActivityImpl

    @Before
    fun setUp() {
        initMocks(this)

        subject = MainActivityImpl()
    }

    @Test
    fun mainActivityImplSetsContentView() {
        subject.onCreate(null, mainActivity)

        verify(mainActivity).setContentView(R.layout.activity_main)
    }
}