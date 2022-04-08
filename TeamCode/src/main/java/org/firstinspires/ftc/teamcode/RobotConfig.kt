package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.hardware.*

/**
 * This code has been modified by FTC team 12051 NotNotNerds**************************************
 * We do not guarantee that your robot will function correctly after you have used this code**********************
 * It is not recommended that you use our modifications with your robot********************************
 * Thank you to those teams who willingly contributed their github code so that I could create this file; I wouldn't have been able to make this otherwise
 */
class RobotConfig(aHardwareMap: HardwareMap?) {
    var FL: DcMotor
    var FR: DcMotor
    var BL: DcMotor
    var BR: DcMotor

    var CA: DcMotor
    var DS: DistanceSensor
    var I1: DcMotor
    var LIFT: DcMotor



    //public Servo seGrabber; //to be used in the future
    private var hardwareMap: HardwareMap? = null //don't know why it needs to be null, but ok
    fun drive(fls: Double, frs: Double, brs: Double, bls: Double) {
        FL.power = fls
        FR.power = frs
        BR.power = brs
        BL.power = bls
    }

    fun stopMoving() {
        FL.power = 0.0
        FR.power = 0.0
        BR.power = 0.0
        BL.power = 0.0
    }

    init {
        hardwareMap = aHardwareMap
        /***
         * config=actual=ch port (actual locations missing currently)
         * fr=fr=0
         * bl=bl=1
         * fl=fl=2
         * br=br=3
         */

        I1 = hardwareMap!!.get(DcMotor::class.java, "I1")
        LIFT = hardwareMap!!.get(DcMotor::class.java, "LIFT")
        CA = hardwareMap!!.get(DcMotor::class.java, "CA")

        // you can use this as a regular DistanceSensor.
        DS = hardwareMap!!.get(DistanceSensor::class.java, "DS")
        FL = hardwareMap!!.get(DcMotor::class.java, "FL")
        BL = hardwareMap!!.get(DcMotor::class.java, "BL")
        FR = hardwareMap!!.get(DcMotor::class.java, "FR")
        BR = hardwareMap!!.get(DcMotor::class.java, "BR")
        FL.direction = DcMotorSimple.Direction.FORWARD
        BL.direction = DcMotorSimple.Direction.REVERSE
        FR.direction = DcMotorSimple.Direction.FORWARD
        BR.direction = DcMotorSimple.Direction.REVERSE



        /* fl.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER); //we don't need encoders where we're going
        bl.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        fl.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);*/
        FL.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        BL.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        FR.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        BR.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
    }
}