package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorSubsystem;

public class ElevatorCommand extends Command{
    private final ElevatorSubsystem m_ElevatorSubsystem;
    private double m_input;
    public ElevatorCommand(
        ElevatorSubsystem c_ElevatorSubsystem,
        double c_input
        )
    {
        this.m_ElevatorSubsystem = c_ElevatorSubsystem;
        this.m_input = c_input;
        addRequirements(m_ElevatorSubsystem);
    }
    
    @Override
        public void execute() {//move motor
            if(m_input > 0.01 || m_input < -0.01){
                m_ElevatorSubsystem.run(m_input);//use for speed
                // m_ElevatorSubsystem.ElevatorToPos(m_input);// use for position control
            }
            else{//brake motor
                m_ElevatorSubsystem.mbrake();
            }
    }
}
