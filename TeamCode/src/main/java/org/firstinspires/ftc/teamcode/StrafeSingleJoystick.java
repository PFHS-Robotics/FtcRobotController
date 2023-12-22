package org.firstinspires.ftc.teamcode;
//Math import
import static java.lang.StrictMath.atan;
import static java.lang.StrictMath.ceil;
import static java.lang.StrictMath.sqrt;
//Robotics import
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "StrafeSingleJoystick")
public class StrafeSingleJoystick extends LinearOpMode {

// ----------EDIT ONLY BELOW----------

    // Motor variables
    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor FrontRight;
    private DcMotor FrontLeft;

    //Other Variables
    boolean moving;
    boolean turning;
    double speed;
    double strafeFactor;
    double strafeSpeed;
    short theta;
    double x;
    double y;
    // Methods
    void move(double front, double back){
            BackRight.setPower(4 * back);
            BackLeft.setPower(4 * back);
            FrontRight.setPower(4 * front);
            FrontLeft.setPower(4 * front);
    }

    void moveStrafe() {
        //Variables
        x = gamepad1.left_stick_x;
        y = gamepad1.left_stick_y;
        theta = (short) atan(x/y);
        int smallTheta = (int) ceil(theta/90);
        strafeFactor = atan(x/y)/90;
        speed = sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        strafeSpeed = strafeFactor * speed;

        //Switch function to differentiate between quadrants
        if(!turning){
            switch(theta) {
                case 0:
                    move(speed, speed);
                    break;
                case 90:
                    move(-speed, speed);
                    break;
                case 180:
                    move(speed, -speed);
                    break;
                case 270:
                    move(-speed, -speed);
                    break;
            }
            switch(smallTheta){
                case 1:
                    move(-strafeSpeed, speed);
                    break;
                case 2:
                    move(speed, -strafeSpeed);
                    break;
                case 3:
                    move(strafeSpeed, -speed);
                    break;
                case 4:
                    move(-speed, strafeSpeed);
                    break;
            }
        }
    }

    void turn(){
            if(!moving) {
                BackRight.setPower(4 * gamepad1.right_stick_x);
                BackLeft.setPower(-4 * gamepad1.right_stick_x);
                FrontRight.setPower((4 * gamepad1.right_stick_x));
                FrontLeft.setPower(-4 * gamepad1.right_stick_x);
            }
    }

    void turningWhileMovingFix(){
        //Moving
        moving = gamepad1.left_stick_y != 0 || gamepad1.left_stick_x != 0;
        turning = gamepad1.left_stick_x != 0;
    }

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */

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
                //Variable-Type Things
                BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
                FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);

                //Methods
                turningWhileMovingFix();
                moveStrafe();
                turn();
            }
        }
    }
}