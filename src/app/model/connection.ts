import { Organization } from './organization';
import { Position } from './position';

export class Connection {
    id: number;
    orgObj: Organization;
    source: Position;
    target: Position;
    activate: boolean;
}