package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class ShootLength extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Shooter m_Shooter;
  private final double m_Length;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootLength(double Length ,Shooter Shooter) {
    m_Length = Length;
    m_Shooter = Shooter;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  m_Shooter.shoot();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Shooter.shoot();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Shooter.Stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (true);
  }
}
