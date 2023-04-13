package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "MotorTest")
public class MotorTest extends LinearOpMode {

// ----------EDIT ONLY BELOW----------

    // Motor variables
    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor FrontRight;
    private DcMotor FrontLeft;

    // Other Variables
    // Code

    // Methods
    //Code


    @Override
    public void runOpMode() {

        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Back Right (0)
                BackRight.setPower(4);
                BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
                // Front Right (2)
                FrontRight.setPower(4);
                FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
                // Back Left (1)
                BackLeft.setPower(4);
                // Front Left (3)
                FrontLeft.setPower(4);
            }
        }
    }
}