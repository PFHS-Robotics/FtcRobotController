package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="MyAutoOp", group="Linear Opmode")
// @Disabled
public class MyAutoOp extends LinearOpMode {
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    public void move(double lpower, double rpower, int msec)
            throws InterruptedException {
        if (opModeIsActive()) {
            leftMotor.setPower(lpower);
            rightMotor.setPower(rpower);
            sleep(msec);
            leftMotor.setPower(0);
            rightMotor.setPower(0);
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        leftMotor  = hardwareMap.dcMotor.get("leftmotor");
        rightMotor = hardwareMap.dcMotor.get("rightmotor");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        move(0.5, 0.5, 2000);    // move forward for two seconds
        move(-0.5, -0.5, 1000);  // move backwards for one second
        move(0.5, 0, 1500);      // turn to right for 1.5 seconds
    }
}