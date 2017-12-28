package com.shields.streamsms.activities

import android.Manifest
import com.shields.streamsms.R
import com.shields.streamsms.service.PermissionHelper
import com.shields.streamsms.service.SMSListener
import io.reactivex.Scheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

class MainActivityImplTest {

    @Mock private lateinit var mainActivityMock: MainActivity
    @Mock private lateinit var permissionHelper: PermissionHelper
    @Mock private lateinit var processSchedulerMock: Scheduler
    @Mock private lateinit var androidSchedulerMock: Scheduler
    @Mock private lateinit var smsListenerMock: SMSListener

    private lateinit var subject: MainActivityImpl

    @Before
    fun setUp() {
        initMocks(this)

        subject = MainActivityImpl(permissionHelper,
                processSchedulerMock,
                androidSchedulerMock,
                smsListenerMock)
    }

    @Test
    fun mainActivityImplSetsContentView() {
        subject.onCreate(null, mainActivityMock)

        verify(mainActivityMock).setContentView(R.layout.activity_main)
    }

    @Test
    fun onCreateRequestsReadSMSPermission() {
        subject.onCreate(null, mainActivityMock)

        verify(permissionHelper).requestPermissionIfNeeded(mainActivityMock, Manifest.permission.READ_SMS)
    }
}