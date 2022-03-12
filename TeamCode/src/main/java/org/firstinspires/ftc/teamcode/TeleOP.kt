package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp


@TeleOp(name = "TeleOP")
class TeleOP: LinearOpMode() {

    private var RC: RobotConfig?=null

    override fun runOpMode() {

        RC = RobotConfig(hardwareMap)

        var m1 = 1.0

        waitForStart()

        while (opModeIsActive()){

            telemetry.addData("Distance: ", RC!!.DS.getDistance())

            var drive=gamepad1.right_stick_x.toDouble()
            var strafe=-gamepad1.left_stick_x.toDouble()
            var rotate=-gamepad1.right_stick_y.toDouble()

            RC!!.BL.power=m1*(drive+rotate+strafe)
            RC!!.BR.power=m1*(drive-rotate+strafe)
            RC!!.FR.power=m1*(-drive+rotate+strafe)
            RC!!.FL.power=m1*(-drive-rotate+strafe)


            RC!!.I1.power = if (gamepad1.left_bumper) {-1.0} else {0.0}
            RC!!.EL.power = if (gamepad1.right_bumper) {-1.0} else {0.0}

            RC!!.CA.power = gamepad1.left_trigger.toDouble()


        }


    }

}