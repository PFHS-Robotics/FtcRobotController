package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Outline")
public class Outline extends LinearOpMode {

// ----------EDIT ONLY BELOW----------

    // Motor variables
    private DcMotor PLACEHOLDER1;
    private DcMotor PLACEHOLDER2;
    private DcMotor PLACEHOLDER3;
    private DcMotor PLACEHOLDER4;

    // Other Variables
    // Code

    // Methods
    //Code


    @Override
    public void runOpMode() {

        PLACEHOLDER1 = hardwareMap.get(DcMotor.class, "PLACEHOLDER1");
        PLACEHOLDER2 = hardwareMap.get(DcMotor.class, "PLACEHOLDER2");
        PLACEHOLDER3 = hardwareMap.get(DcMotor.class, "PLACEHOLDER3");
        PLACEHOLDER4 = hardwareMap.get(DcMotor.class, "PLACEHOLDER4");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
               // Code
            }
        }
    }
}