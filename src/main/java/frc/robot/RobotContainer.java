// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.math.MathUtil;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import commands
import frc.robot.commands.armsDownL;
import frc.robot.commands.armsDownR;
import frc.robot.commands.armsUpL;
import frc.robot.commands.armsUpR;
import frc.robot.commands.rollerSpinIn;
import frc.robot.commands.rollorSpinOut;
import frc.robot.commands.PickupLength;
import frc.robot.commands.ReverseShot;
import frc.robot.commands.shootSlow;
import frc.robot.commands.shootFast;
import frc.robot.commands.ShootLength;
import frc.robot.commands.DriveLength;
import frc.robot.commands.aimAmp;
import frc.robot.commands.aimSpeaker;

//import subsystems
import frc.robot.subsystems.ClimbLe;
import frc.robot.subsystems.ClimbR;
import frc.robot.subsystems.Pickup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  
  
  // subsystems
    private final ClimbLe m_ClimbLe = new ClimbLe();
    private final ClimbR m_ClimbR = new ClimbR();
    private final Pickup m_Pickup = new Pickup();
    private final Shooter m_Shooter = new Shooter();
    private final DriveTrain m_robotDrive = new DriveTrain();

  // Joysticks
    private final Joystick buttonBoard = new Joystick(1);
    private final Joystick m_StickOfHope = new Joystick(0);
     //Chooser for Auto
     SendableChooser<Command> m_chooser = new SendableChooser<>();

  //Commands
    private final armsDownL m_ArmsDownL = new armsDownL(m_ClimbLe);
    private final armsDownR m_ArmsDownR = new armsDownR(m_ClimbR);
    private final armsUpL m_ArmsUpL = new armsUpL(m_ClimbLe);
    private final armsUpR m_ArmsUpR = new armsUpR(m_ClimbR);
    private final shootFast m_ShootSlow = new shootFast(m_Shooter);
    private final ReverseShot m_ReverseShot = new ReverseShot(m_Shooter);
    private final shootSlow m_Shootslow = new shootSlow(m_Shooter);
    private final aimAmp m_aimAmp = new aimAmp(m_robotDrive);
    private final aimSpeaker m_aimSpeaker = new aimSpeaker(m_robotDrive);
    private final rollerSpinIn m_LowIn = new rollerSpinIn(m_Pickup);
    private final rollorSpinOut m_LowOut = new rollorSpinOut(m_Pickup);
    // Default
    
   


    //Button setup
    private JoystickButton armsDownL = new JoystickButton(buttonBoard, 6);
    private JoystickButton armsDownR = new JoystickButton(buttonBoard, 7);
    private JoystickButton armsUpL = new JoystickButton(buttonBoard, 5);
    private JoystickButton armsUpR = new JoystickButton(buttonBoard, 4);
    private JoystickButton shootSlow = new JoystickButton(buttonBoard, 1);
    private JoystickButton ShooterPistonOn = new JoystickButton(buttonBoard, 2);
    private JoystickButton ReverseShot = new JoystickButton(buttonBoard, 14);
    private JoystickButton shootsmall = new JoystickButton(buttonBoard, 3);
    private JoystickButton lowIn = new JoystickButton(buttonBoard, 8);
    private JoystickButton lowOut = new JoystickButton(buttonBoard, 10);
    private JoystickButton PickupPistonOn = new JoystickButton(buttonBoard, 9);
    private JoystickButton aimAmp = new JoystickButton(buttonBoard, 10);
    private JoystickButton aimSpeaker = new JoystickButton(buttonBoard, 11);
       // Robot maker code from last year, may or may not be needed. 
    //m_chooser.setDefaultOption("Autonomous Command", new Autos(m_driveTrain, m_Shooter, m_Pickup);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    //Configure driving default
    m_robotDrive.setDefaultCommand(
      // Forward motion controls x speed (forward), sideways motion controls y speed (sideways).
        new RunCommand ( 
                () -> m_robotDrive.drive(
                -MathUtil.applyDeadband(m_StickOfHope.getY(), DriveConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_StickOfHope.getX(), DriveConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_StickOfHope.getZ(), DriveConstants.kDriveDeadband),
                DriveConstants.kTeleField), m_robotDrive)
        );
    // Configure the trigger bindings
    configureBindings();
  }
  

  
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    armsDownL.whileTrue(m_ArmsDownL);
    armsDownR.whileTrue(m_ArmsDownR);
    armsUpL.whileTrue(m_ArmsUpL);
    armsUpR.whileTrue(m_ArmsUpR);
    shootSlow.whileTrue(m_ShootSlow);
    ReverseShot.whileTrue(m_ReverseShot);
    shootsmall.whileTrue(m_Shootslow);
    ShooterPistonOn.toggleOnTrue(new StartEndCommand( m_Shooter::dump , m_Shooter::undump, m_Shooter));
    lowIn.whileTrue(m_LowIn);
    lowOut.whileTrue(m_LowOut);
    PickupPistonOn.toggleOnTrue(new StartEndCommand(m_Pickup::drop, m_Pickup::undrop, m_Pickup));
    aimAmp.toggleOnTrue(m_aimAmp);
    aimSpeaker.toggleOnTrue(m_aimSpeaker);
    

    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return m_chooser.getSelected();
  }
  
}
