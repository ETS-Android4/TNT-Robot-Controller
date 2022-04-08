package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit.*
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.*


@TeleOp(name = "TeleOP")
class TeleOP: LinearOpMode() {

    private var RC: RobotConfig?=null

    override fun runOpMode() {

        RC = RobotConfig(hardwareMap)

        var m1 = 1.0

        waitForStart()

        while (opModeIsActive()){

            telemetry.addData("Distance: ", RC!!.DS.getDistance(MM))

            var drive=gamepad1.right_stick_x.toDouble()
            var strafe=-gamepad1.left_stick_x.toDouble()
            var rotate=-gamepad1.right_stick_y.toDouble()

            var cannonPower = gamepad1.left_trigger.toDouble() - gamepad1.right_trigger.toDouble()

            RC!!.BL.power=m1*(drive+rotate+strafe)
            RC!!.BR.power=m1*(drive-rotate+strafe)
            RC!!.FR.power=m1*(-drive+rotate+strafe)
            RC!!.FL.power=m1*(-drive-rotate+strafe)


            RC!!.I1.power = if (gamepad1.left_bumper) {0.60} else {0.0}
            RC!!.LIFT.power = if (gamepad1.right_bumper) {-0.3} else {0.0}
            RC!!.CA.zeroPowerBehavior = if (gamepad1.right_trigger  > 0.05) {BRAKE} else {FLOAT}
            RC!!.CA.power = if (cannonPower > 0.0) {-0.5} else {0.0}

            telemetry.update()
        }


    }

}